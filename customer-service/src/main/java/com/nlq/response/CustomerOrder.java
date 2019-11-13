package com.nlq.response;

import com.nlq.model.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Setter
@Getter
public class CustomerOrder {
    private Customer customer;
    private List<Order> orders;
}
