package com.start.domain_driven_design.order.domain;

import java.util.List;

public enum OrderStatus {
    BEFORE_PAYMENT {
        @Override
        boolean isAvailableStatus(OrderStatus status) {
            List<OrderStatus> targetList = List.of(OrderStatus.PAYMENT, OrderStatus.CANCELED);
            return targetList.contains(status);
        }
    },
    PAYMENT {
        @Override
        boolean isAvailableStatus(OrderStatus status) {
            List<OrderStatus> targetList = List.of(OrderStatus.PREPARING, OrderStatus.CANCELED);
            return targetList.contains(status);
        }
    },
    PREPARING {
        @Override
        boolean isAvailableStatus(OrderStatus status) {
            List<OrderStatus> targetList = List.of(OrderStatus.SHIPPING, OrderStatus.CANCELED);
            return targetList.contains(status);
        }
    },
    SHIPPING {
        @Override
        boolean isAvailableStatus(OrderStatus status) {
            List<OrderStatus> targetList = List.of(OrderStatus.COMPLETED, OrderStatus.CANCELED);
            return targetList.contains(status);
        }
    },
    COMPLETED {
        @Override
        boolean isAvailableStatus(OrderStatus status) {
            return false;
        }
    },
    CANCELED {
        @Override
        boolean isAvailableStatus(OrderStatus status) {
            return false;
        }
    };

    abstract boolean isAvailableStatus(OrderStatus status);
}
