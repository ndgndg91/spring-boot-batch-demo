package com.batch.demo.order.configuration;

import com.batch.demo.order.batch.OrderReader;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public OrderReader orderReader(){
        return new OrderReader();
    }

}
