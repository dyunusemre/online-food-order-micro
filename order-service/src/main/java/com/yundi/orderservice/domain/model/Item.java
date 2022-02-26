package com.yundi.orderservice.domain.model;

import com.yundi.orderservice.domain.enums.ItemType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Item {
    private ItemType itemType;
    private String name;
    private int quantity;
    private double price;
}
