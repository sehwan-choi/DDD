package com.start.domain_driven_design.order.controller.dto;

import com.start.domain_driven_design.order.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderStatusChangeRequest {

    private OrderStatus status;
}
