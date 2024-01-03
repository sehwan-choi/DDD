package com.start.domain_driven_design.order.repository;

import com.start.domain_driven_design.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
