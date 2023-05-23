package com.example.shop.repositories;

import com.example.shop.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;


public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
