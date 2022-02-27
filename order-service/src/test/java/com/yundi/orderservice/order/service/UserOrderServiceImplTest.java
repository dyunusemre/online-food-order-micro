package com.yundi.orderservice.order.service;

import com.yundi.orderservice.client.PaymentClientWrapper;
import com.yundi.orderservice.domain.model.UserOrder;
import com.yundi.orderservice.domain.repository.UserOrderRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class UserOrderServiceImplTest {
    @InjectMocks
    UserOrderServiceImpl userOrderService;

    @Mock
    PaymentClientWrapper paymentClientWrapper;

    @Mock
    UserOrderRepository userOrderRepository;

    @Test
    public void saveOrder_test() {
        UserOrder userOrder = UserOrder.builder().id("123").build();
        when(userOrderRepository.save(userOrder)).thenReturn(userOrder);
        userOrderService.saveOrder(userOrder);
        assertEquals("123", userOrder.getId());
    }
}
