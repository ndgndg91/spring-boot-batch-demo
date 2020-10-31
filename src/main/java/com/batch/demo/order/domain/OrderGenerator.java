package com.batch.demo.order.domain;

import com.batch.demo.order.repository.LineItemRepository;
import com.batch.demo.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class OrderGenerator {

    private final OrderRepository orderRepository;
    private final LineItemRepository lineItemRepository;

    @Scheduled(fixedRate = 1000)
    void create() {
        Order order = Order.builder()
                .buyer(new Buyer("남동길", "ndgndg91@gmail.com", "010-7225-5198"))
                .paymentGatewayType(PaymentGateway.NONE)
                .payMethod(PayMethod.REMITTANCE)
                .status(OrderStatus.ACTIVE)
                .build();

        orderRepository.save(order);

        ShippingAddress shippingAddress = ShippingAddress.builder()
                .destinationName("우리 집")
                .recipientName("남동길")
                .recipientPhone("010-7225-5198")
                .addressLine1("서울시 중구 퇴계로 235")
                .addressLine2("남산센트럴자이 B동 804호")
                .zipCode("04558")
                .city("서울")
                .country("KR")
                .build();

        LineItem li1 = LineItem.builder()
                .productName("맥북 프로 16인치")
                .productPrice(new BigDecimal(3_600_000))
                .order(order)
                .quantity(1)
                .status(LineItemStatus.CREATED)
                .shippingAddress(shippingAddress)
                .build();
        LineItem li2 = LineItem.builder()
                .productName("아이패드 프로 13인치 256GB")
                .productPrice(new BigDecimal(1_300_000))
                .order(order)
                .quantity(1)
                .status(LineItemStatus.CREATED)
                .shippingAddress(shippingAddress)
                .build();
        LineItem li3 = LineItem.builder()
                .productName("아이폰12 프로 블랙")
                .productPrice(new BigDecimal(1_300_000))
                .order(order)
                .quantity(1)
                .status(LineItemStatus.CREATED)
                .shippingAddress(shippingAddress)
                .build();

        lineItemRepository.save(li1);
        lineItemRepository.save(li2);
        lineItemRepository.save(li3);
    }
}
