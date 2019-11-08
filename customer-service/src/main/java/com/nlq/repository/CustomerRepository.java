package com.nlq.repository;

import com.nlq.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findCustomerById(long id);

    long createCustomer(Customer customer);
}
