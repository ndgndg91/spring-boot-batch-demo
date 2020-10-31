package com.batch.demo.order.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "`order`")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "o_id")
    private Long oId;

    @Embedded
    private Buyer buyer;

    @Enumerated(EnumType.STRING)
    private PayMethod payMethod;

    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGatewayType;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Builder
    public Order(Buyer buyer, PayMethod payMethod, PaymentGateway paymentGatewayType, OrderStatus status) {
        this.buyer = buyer;
        this.payMethod = payMethod;
        this.paymentGatewayType = paymentGatewayType;
        this.status = status;
    }
}
