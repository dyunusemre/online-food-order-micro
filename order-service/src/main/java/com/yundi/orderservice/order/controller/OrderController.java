package com.yundi.orderservice.order.controller;

import com.yundi.orderservice.order.request.CreateOrderRequest;
import com.yundi.orderservice.order.service.UserOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final UserOrderService userOrderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUserOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return userOrderService.createOrder(createOrderRequest);
    }
}
