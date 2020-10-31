package com.batch.demo.order.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Embeddable
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ShippingAddress {

    private String destinationName;
    private String recipientName;
    private String recipientPhone;
    private String addressLine1;
    private String addressLine2;
    private String zipCode;
    private String city;
    private String country;
}
