package com.yundi.orderservice.order.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ItemDto {
    private String name;
    private int quantity;
    private double price;
}
