package com.nlq.repository;

import com.nlq.model.Customer;
import com.nlq.response.CustomerOrder;

import java.util.List;

public interface CustomerRepository {
    List<Customer> getAllCustomer();

    Customer findCustomerById(long id);

    long createCustomer(Customer customer);

    CustomerOrder listCustomerOrderByCustomerId(long id);
}
