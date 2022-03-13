package com.yundi.authservice.userauth.service;

import com.yundi.authservice.exception.AlreadyExistsException;
import com.yundi.authservice.userauth.enums.RoleEnum;
import com.yundi.authservice.userauth.model.Role;
import com.yundi.authservice.userauth.model.UserAuth;
import com.yundi.authservice.userauth.repository.RoleRepository;
import com.yundi.authservice.userauth.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final PasswordEncoder encoder;
    private final UserAuthRepository userAuthRepository;
    private final RoleService roleService;

    @Override
    public UserAuth saveUserAuth(UserAuth userAuth) {
        userValidations(userAuth);
        userAuth.setRoles(roleService.findRoleByName(RoleEnum.ROLE_USER));
        userAuth.setPassword(encoder.encode(userAuth.getPassword()));
        return userAuthRepository.save(userAuth);
    }

    @Override
    public UserDetails findUserAuthDetailsByUsername(String username) {
        UserAuth userAuth = userAuthRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(userAuth.getUsername(), userAuth.getPassword(), getAuthorities(userAuth));
    }

    private Set<GrantedAuthority> getAuthorities(UserAuth user) {
        return user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toSet());
    }

    private void userValidations(UserAuth userAuth) {
        if (isUsernameUnique(userAuth.getUsername()))
            throw new AlreadyExistsException();
    }

    private boolean isUsernameUnique(String username) {
        return userAuthRepository.findByUsername(username).isPresent();
    }
}
