package com.yundi.paymentservice.payment.controller;

import com.yundi.paymentservice.payment.dto.GetPaymentRequest;
import com.yundi.paymentservice.payment.dto.GetPaymentResponse;
import com.yundi.paymentservice.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/make")
    public GetPaymentResponse makePayment(@RequestBody GetPaymentRequest request) {
        return paymentService.makePayment();
    }
}
