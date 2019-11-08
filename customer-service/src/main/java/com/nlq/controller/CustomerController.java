package com.nlq.controller;

import com.nlq.model.Customer;
import com.nlq.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/createCustomer")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerRepository.createCustomer(customer),HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable long customerId){
        return new ResponseEntity<>(customerRepository.findCustomerById(customerId),HttpStatus.OK);
    }
}
