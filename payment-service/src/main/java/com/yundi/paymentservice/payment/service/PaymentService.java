package com.yundi.paymentservice.payment.service;

import com.yundi.paymentservice.payment.dto.GetPaymentResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    GetPaymentResponse makePayment();
}
