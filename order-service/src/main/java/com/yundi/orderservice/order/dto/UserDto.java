package com.yundi.orderservice.order.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserDto {
    private String userId;
    private String phoneNumber;
    private String email;
    private AddressDto address;
}
