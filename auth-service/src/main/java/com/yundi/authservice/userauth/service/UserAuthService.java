package com.yundi.authservice.userauth.service;

import com.yundi.authservice.userauth.enums.RoleEnum;
import com.yundi.authservice.userauth.model.Role;
import com.yundi.authservice.userauth.model.UserAuth;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserAuthService {

    UserAuth saveAuth(UserAuth userAuth);

    UserDetails findUserDetailsByUsername(String username);

    Set<Role> findRoleByName(RoleEnum role);
}
