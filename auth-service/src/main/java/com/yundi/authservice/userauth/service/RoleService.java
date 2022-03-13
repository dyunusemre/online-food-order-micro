package com.yundi.authservice.userauth.service;

import com.yundi.authservice.userauth.enums.RoleEnum;
import com.yundi.authservice.userauth.model.Role;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RoleService {
    Set<Role> findRoleByName(RoleEnum role);

}
