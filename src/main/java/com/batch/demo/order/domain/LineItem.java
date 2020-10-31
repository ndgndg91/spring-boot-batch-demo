package com.batch.demo.order.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "line_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineItem {

    @Id
    @GeneratedValue
    @Column(name = "l_id")
    private Long lId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "l_status")
    @Enumerated(EnumType.STRING)
    private LineItemStatus status;

    @Embedded
    private ShippingAddress shippingAddress;

    @ManyToOne
    @JoinColumn(name = "o_id")
    private Order order;

    @Builder
    LineItem(Long lId, String productName, BigDecimal productPrice, int quantity, LineItemStatus status, ShippingAddress shippingAddress, Order order) {
        this.lId = lId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.order = order;
    }
}


