package com.yundi.paymentservice.payment.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class GetPaymentRequest {
    private String cardId;
    private double price;
}
