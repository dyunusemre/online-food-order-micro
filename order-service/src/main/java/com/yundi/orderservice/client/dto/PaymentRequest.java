package com.yundi.orderservice.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@RequiredArgsConstructor
public class PaymentRequest {
    private String cardId;
    private double price;
}
