package com.yundi.orderservice.order.request;

import com.yundi.orderservice.order.dto.ItemDto;
import com.yundi.orderservice.order.dto.RestaurantDto;
import com.yundi.orderservice.order.dto.UserDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CreateOrderRequest {
    private UserDto user;
    private RestaurantDto restaurant;
    private List<ItemDto> items;
    private String cardId;
    private double totalBasketPrice;
}
