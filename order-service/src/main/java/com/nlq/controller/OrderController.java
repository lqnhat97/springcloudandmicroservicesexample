package com.nlq.controller;

import com.nlq.model.Customer;
import com.nlq.model.Order;
import com.nlq.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "/order/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable long orderId){
        return new ResponseEntity<>(orderRepository.findOrderById(orderId), HttpStatus.OK);
    }

    @GetMapping(value = "/order/orderByCustomer/{customerId}")
    public ResponseEntity<?> getOrderByCustomerId(@PathVariable long customerId){
        return new ResponseEntity<>(orderRepository.findOrderByCustomerId(customerId), HttpStatus.OK);
    }

    @PostMapping(value = "/order/createOrder")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order){
        return new ResponseEntity<>(orderRepository.createOrder(order),HttpStatus.OK);
    }

    @GetMapping(value = "/allCustomer")
    public ResponseEntity<?> getAllCustomer() {
        return new ResponseEntity<>(orderRepository.getAllCustomer(),HttpStatus.OK);
    }
}
