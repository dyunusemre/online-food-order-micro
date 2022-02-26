package com.yundi.orderservice.client;

import com.yundi.orderservice.client.dto.PaymentRequest;
import com.yundi.orderservice.client.dto.PaymentResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentClientWrapper {

    private final PaymentClient paymentClient;

    public PaymentResponse doPayment(PaymentRequest request) {
        try {
            return paymentClient.getPayment(request);
        } catch (FeignException feignException) {
            log.error("do payment failes {}", feignException.getMessage());
            throw feignException;
        }
    }
}
