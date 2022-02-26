package com.yundi.authservice.userauth.repository;

import com.yundi.authservice.userauth.enums.RoleEnum;
import com.yundi.authservice.userauth.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(RoleEnum name);
}
