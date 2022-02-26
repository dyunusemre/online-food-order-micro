package com.yundi.authservice.userauth.model;

import com.yundi.authservice.userauth.enums.RoleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document("role")
public class Role {
    @Id
    private String id;
    private RoleEnum name;
}
