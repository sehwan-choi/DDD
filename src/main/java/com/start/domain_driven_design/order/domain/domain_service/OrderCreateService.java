package com.start.domain_driven_design.order.domain.domain_service;

import com.start.domain_driven_design.order.controller.dto.OrderRequest;

public interface OrderCreateService {

    OrderResult createOrder(OrderRequest request);
}
