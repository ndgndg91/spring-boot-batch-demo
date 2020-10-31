package com.batch.demo.order.domain;

public enum PayMethod {
    CARD("신용/체크카드"),
    MOBILE("휴대폰 결제"),
    BANK_TRANSFER("계좌 이체"),
    VIRTUAL_ACCOUNT("가상 계좌"),

    REMITTANCE("무통장 입금"),
    RESERVES("적립금으로 전부 결제"),
    COUPON("쿠폰으로 전부 결제");

    private final String description;

    PayMethod(String description) {
        this.description = description;
    }
}
