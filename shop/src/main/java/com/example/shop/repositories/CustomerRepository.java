package com.example.shop.repositories;

import com.example.shop.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
}
