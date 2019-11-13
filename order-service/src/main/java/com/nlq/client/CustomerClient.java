package com.nlq.client;

import com.nlq.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerClient {
    @GetMapping(value = "/customer/findAll")
    List<Customer> getAllCustomer();
}
