package com.start.domain_driven_design.order.service;

import com.start.domain_driven_design.common.annotation.DomainService;
import com.start.domain_driven_design.order.domain.Order;
import com.start.domain_driven_design.order.domain.OrderStatus;
import com.start.domain_driven_design.order.exception.OrderNotFoundException;
import com.start.domain_driven_design.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class OrderStatusChangeServiceImpl implements OrderStatusChangeService{

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void orderStatusChange(Long orderId, OrderStatus changeStatus) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
        order.statusChange(changeStatus);
    }
}
