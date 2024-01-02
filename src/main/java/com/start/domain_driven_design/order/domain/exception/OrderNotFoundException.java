package com.start.domain_driven_design.order.domain.exception;

import lombok.Getter;

public class OrderNotFoundException extends RuntimeException{

    @Getter
    private final Long orderId;

    public OrderNotFoundException(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getMessage() {
        return "Order Id \"" + orderId + "\" is not Found!";
    }
}
