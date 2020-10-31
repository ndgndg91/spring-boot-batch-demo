package com.batch.demo.order.repository;

import com.batch.demo.order.domain.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
}
