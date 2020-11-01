package com.batch.demo.order.configuration;

import com.batch.demo.order.configuration.dto.OrderDTO;
import com.batch.demo.order.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Log4j2
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job testJob(){
        return this.jobBuilderFactory.get("testJob").start(testStep()).build();
    }

    @Bean
    public Step testStep(){
        return this.stepBuilderFactory.get("testStep").tasklet((contribution, chunkContext) -> {
            log.info("tasklet execute!");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(DataSource dataSource) {
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();

        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("SELECT o_id, email, name, phone, pay_method, payment_gateway_type, status");
        queryProvider.setFromClause("FROM `order`");
        queryProvider.setWhereClause("WHERE pay_method = 'REMITTANCE' AND status = 'ACTIVE'");
        queryProvider.setSortKey("o_id");

        return queryProvider;
    }

    @Bean
    public ItemReader<Order> orderItemReader(DataSource dataSource, PagingQueryProvider queryProvider) {
        return new JdbcPagingItemReaderBuilder()
                .name("orderPagingItemReader")
                .dataSource(dataSource)
                .pageSize(1)
                .queryProvider(queryProvider)
                .rowMapper(new BeanPropertyRowMapper<>(OrderDTO.class))
                .build();
    }
}