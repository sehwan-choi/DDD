package com.start.domain_driven_design.order.domain;

public enum OrderStatus {
    BEFORE_PAYMENT,
    PAYMENT,
    PREPARING,
    SHIPPING,
    COMPLETE,
    CANCEL
}
