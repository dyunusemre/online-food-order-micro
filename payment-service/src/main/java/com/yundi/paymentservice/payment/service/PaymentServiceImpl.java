package com.yundi.paymentservice.payment.service;

import com.yundi.paymentservice.payment.dto.GetPaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public GetPaymentResponse makePayment() {
        //TODO Payment Got from user send event here too
        return GetPaymentResponse.builder()
                .message("Payment Successful")
                .build();
    }
}
