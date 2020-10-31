package com.batch.demo.order.domain;

import java.util.Collections;
import java.util.List;

import static com.batch.demo.order.domain.PayMethod.*;

public enum PaymentGateway {
    NONE(Collections.emptyList()),
    NICE_PAY(List.of(CARD, MOBILE, BANK_TRANSFER, VIRTUAL_ACCOUNT)),
    INICIS(List.of(CARD, MOBILE, BANK_TRANSFER, VIRTUAL_ACCOUNT)),
    KAKAO_PAY(Collections.emptyList()),
    NAVER_PAY(Collections.emptyList());

    private final List<PayMethod> allowedPayMethods;

    PaymentGateway(List<PayMethod> allowedPayMethods) {
        this.allowedPayMethods = allowedPayMethods;
    }
}
