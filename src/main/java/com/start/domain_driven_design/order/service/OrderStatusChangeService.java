package com.start.domain_driven_design.order.service;

import com.start.domain_driven_design.order.domain.OrderStatus;

public interface OrderStatusChangeService {

    void orderStatusChange(Long orderId, OrderStatus changeStatus);
}
