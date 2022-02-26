package com.yundi.orderservice.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@Document("user-order")
public class UserOrder {
    @Id
    private String id;
    private String userId;
    private List<Item> itemList;
    private double totalBasket;
}
