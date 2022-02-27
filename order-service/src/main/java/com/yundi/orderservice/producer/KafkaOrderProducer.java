package com.yundi.orderservice.producer;

import com.yundi.orderservice.order.request.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderProducer {
    private static final String BINDING_NAME = "userOrder";
    private final StreamBridge streamBridge;


    public void sendCreatedOrderEvent(CreateOrderRequest createOrderRequest) {
        streamBridge.send(BINDING_NAME, getOrderData(createOrderRequest));
        log.info("Created Order Information sent {}", "null");
    }

    private OrderData getOrderData(CreateOrderRequest createOrderRequest) {
        return OrderData
                .builder()
                .items(createOrderRequest.getItems())
                .userDto(createOrderRequest.getUser())
                .restaurantDto(createOrderRequest.getRestaurant())
                .build();
    }
}
