package com.yundi.authservice.auth.service;

import com.yundi.authservice.auth.dto.AuthenticationRequest;
import com.yundi.authservice.auth.dto.AuthenticationResponse;
import com.yundi.authservice.auth.dto.RegisterRequest;
import com.yundi.authservice.exception.CredentialException;
import com.yundi.authservice.exception.TokenException;
import com.yundi.authservice.producer.KafkaProducer;
import com.yundi.authservice.security.jwt.JwtUtil;
import com.yundi.authservice.userauth.model.UserAuth;
import com.yundi.authservice.userauth.service.UserAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final UserAuthService userAuthService;
    private final AuthenticationManager authenticationManager;
    private final KafkaProducer kafkaProducer;

    public AuthenticationResponse sendUserAndGetAccessTokenByRegister(RegisterRequest registerRequest) {
        UserAuth userAuth = saveUserAndSendEvent(registerRequest);
        UserDetails userDetails = userAuthService.findUserDetailsByUsername(userAuth.getUsername());
        return createTokens(userDetails);
    }

    public AuthenticationResponse getAccessTokenByCredentials(AuthenticationRequest request) {
        Authentication authentication = authenticateUser(request.getUsername(), request.getPassword());
        return createTokens((UserDetails) authentication.getPrincipal());
    }

    public AuthenticationResponse getAccessTokenByRefresh(HttpServletRequest request) {
        String refreshToken = getRefreshToken(request);
        String accessToken = jwtUtil.createAccessTokenByRefreshToken(refreshToken);
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private UserAuth saveUserAndSendEvent(RegisterRequest registerRequest) {
        UserAuth userAuth = userAuthService.saveAuth(UserAuth.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .build());

        kafkaProducer.sendRegisteredUserMessage(registerRequest);
        return userAuth;
    }

    private AuthenticationResponse createTokens(UserDetails userDetails) {
        String accessToken = jwtUtil.createTokenByUserDetailsAndTokenType(userDetails, "access_token");
        String refreshToken = jwtUtil.createTokenByUserDetailsAndTokenType(userDetails, "refresh_token");
        return AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private String getRefreshToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization.isEmpty())
            throw new TokenException();

        return authorization.substring("Bearer ".length());
    }

    private Authentication authenticateUser(String username, String password) {
        try {
            UserDetails userDetails = userAuthService.findUserDetailsByUsername(username);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), password);
            log.info("{} Logged in", username);
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (Exception ex) {
            throw new CredentialException();
        }
    }
}
