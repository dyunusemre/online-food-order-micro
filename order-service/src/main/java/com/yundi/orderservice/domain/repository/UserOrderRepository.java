package com.yundi.orderservice.domain.repository;

import com.yundi.orderservice.domain.model.UserOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrderRepository extends MongoRepository<UserOrder, String> {
}
