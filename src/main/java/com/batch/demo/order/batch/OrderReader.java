package com.batch.demo.order.batch;

import com.batch.demo.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

@RequiredArgsConstructor
public class OrderReader implements ItemReader<Order> {


    @Override
    public Order read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
