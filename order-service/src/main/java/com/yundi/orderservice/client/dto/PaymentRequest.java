package com.yundi.orderservice.client.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class PaymentRequest {
    private String cardId;
    private double price;
}
