package com.yundi.orderservice.order.controller;

import com.yundi.orderservice.order.request.CreateOrderRequest;
import com.yundi.orderservice.order.service.UserOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserOrderService userOrderService;

    @Test
    public void createUserOrder_basic() {
        CreateOrderRequest createOrderRequest = CreateOrderRequest.builder()
                .totalBasketPrice(12.5)
                .cardId("123")
                .build();
    }
}
