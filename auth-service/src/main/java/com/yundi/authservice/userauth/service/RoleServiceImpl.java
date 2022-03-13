package com.yundi.authservice.userauth.service;

import com.yundi.authservice.userauth.enums.RoleEnum;
import com.yundi.authservice.userauth.model.Role;
import com.yundi.authservice.userauth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Set<Role> findRoleByName(RoleEnum name) {
        return Collections.singleton(roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Role Couldnt Fine")));
    }
}
