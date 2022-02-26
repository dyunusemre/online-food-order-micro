package com.yundi.orderservice.producer;

import com.yundi.orderservice.order.dto.ItemDto;
import com.yundi.orderservice.order.dto.RestaurantDto;
import com.yundi.orderservice.order.dto.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@Builder
public class OrderData {
    private UserDto userDto;
    private RestaurantDto restaurantDto;
    private List<ItemDto> items;
}
