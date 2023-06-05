package com.example.shop.repositories;

import com.example.shop.entities.Customer;
import com.example.shop.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    boolean existsByPassword(String password);
    boolean existsById(Integer id);
}
