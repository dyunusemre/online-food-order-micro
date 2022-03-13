package com.yundi.authservice.userauth.service;

import com.yundi.authservice.userauth.model.UserAuth;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public interface UserAuthService {

    UserAuth saveUserAuth(UserAuth userAuth);

    UserDetails findUserAuthDetailsByUsername(String username);
}
