package com.yundi.orderservice.order.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class RestaurantDto {
    private String restaurantId;
    private String name;
}
