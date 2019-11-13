package com.nlq.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private long orderId;
    private String status;
    private long customerId;
    private long total;
}
