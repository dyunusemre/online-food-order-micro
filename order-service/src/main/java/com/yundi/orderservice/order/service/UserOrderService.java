package com.yundi.orderservice.order.service;

import com.yundi.orderservice.domain.model.UserOrder;
import com.yundi.orderservice.order.request.CreateOrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserOrderService {
    void saveOrder(UserOrder userOrder);

    String createOrder(CreateOrderRequest createOrderRequest);
}
