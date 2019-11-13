package com.nlq.client;

import com.nlq.response.CustomerOrder;
import com.nlq.response.Order;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {
    @GetMapping(value = "/order/orderByCustomer/{customerId}")
    List<Order> getOrderById(@PathVariable("customerId") long customerId);
}
