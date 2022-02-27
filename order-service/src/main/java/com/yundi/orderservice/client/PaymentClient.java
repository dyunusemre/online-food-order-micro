package com.yundi.orderservice.client;

import com.yundi.orderservice.client.dto.PaymentRequest;
import com.yundi.orderservice.client.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @PostMapping("/payment/make")
    PaymentResponse getPayment(@RequestBody PaymentRequest request);
}
