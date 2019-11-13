package com.nlq.repository;

import com.nlq.model.Customer;
import com.nlq.model.Order;

import java.util.List;

public interface OrderRepository {
    long createOrder(Order order);
    Order findOrderById(long id);
    List<Order> findOrderByCustomerId(long id);
    Order updateOrderById(long id);
    long deleteOrderById(long id);
    List<Customer> getAllCustomer();
}
// QueryDSL neu con time
