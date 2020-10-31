package com.batch.demo.order.domain;

public enum LineItemStatus {
    CREATED,
    WAIT_PAYMENT,
    COMPLETE_PAYMENT,
    READY_DELIVERY,
    ON_DELIVERY,
    COMPLETE_DELIVERY,

    REQUEST_REFUND,
    REQUEST_EXCHANGE,

    PURCHASE_CONFIRMATION

}
