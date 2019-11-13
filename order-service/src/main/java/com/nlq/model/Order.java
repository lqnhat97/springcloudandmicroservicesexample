package com.nlq.model;

import lombok.Getter;
import lombok.Setter;
import rx.BackpressureOverflow;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order_tb")
public class Order extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "status")
    private String status;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "total")
    private long total;

    public Order(){}

}
