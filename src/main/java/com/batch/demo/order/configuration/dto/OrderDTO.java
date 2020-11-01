package com.batch.demo.order.configuration.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {
    private Long oId;
    private String name;
    private String email;
    private String phone;
    private String payMethod;
    private String paymentGatewayType;
    private String orderStatus;
}
