package com.yundi.userservice.user.dto;

import com.yundi.userservice.user.model.Address;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileResponse {
    private String name;
    private String lastName;
    private String email;
    private String username;
    private Address address;
}
