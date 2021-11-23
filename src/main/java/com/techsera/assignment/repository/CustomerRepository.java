package com.techsera.assignment.repository;

import com.techsera.assignment.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByNameAndPassword(String name, String password);
}
