package com.yundi.orderservice.order.service;

import com.yundi.orderservice.client.PaymentClientWrapper;
import com.yundi.orderservice.client.dto.PaymentRequest;
import com.yundi.orderservice.client.dto.PaymentResponse;
import com.yundi.orderservice.domain.model.UserOrder;
import com.yundi.orderservice.domain.repository.UserOrderRepository;
import com.yundi.orderservice.order.request.CreateOrderRequest;
import com.yundi.orderservice.producer.KafkaOrderProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserOrderServiceImpl implements UserOrderService {

    private final UserOrderRepository userOrderRepository;

    private final PaymentClientWrapper paymentClient;

    private final KafkaOrderProducer kafkaOrderProducer;

    @Override
    public void saveOrder(UserOrder userOrder) {
        userOrderRepository.save(userOrder);
    }

    @Override
    public String createOrder(CreateOrderRequest createOrderRequest) {
        makePaymentAndSendEvent(createOrderRequest);
        saveOrder(getUserOrder(createOrderRequest));
        return "Order Created";
    }

    public void makePaymentAndSendEvent(CreateOrderRequest createOrderRequest) {
        PaymentResponse response = paymentClient.doPayment(getPaymentRequest(createOrderRequest.getCard().getCardId(), createOrderRequest.getTotalBasketPrice()));
        if (response != null) {
            kafkaOrderProducer.sendCreatedOrderEvent(createOrderRequest);
        }
    }

    private UserOrder getUserOrder(CreateOrderRequest createOrderRequest) {
        return UserOrder.builder()
                .userId(createOrderRequest.getUser().getUserId())
                .totalBasket(createOrderRequest.getTotalBasketPrice())
                .build();
    }

    private PaymentRequest getPaymentRequest(String cardId, double price) {
        return PaymentRequest.builder()
                .cardId(cardId)
                .price(price)
                .build();
    }
}
