package com.start.domain_driven_design.order.exception;

public class OrderStatusChangeException extends RuntimeException{

    private final String currentStatus;
    private final String changeStatus;

    public OrderStatusChangeException(String currentStatus, String changeStatus) {
        this.currentStatus = currentStatus;
        this.changeStatus = changeStatus;
    }

    @Override
    public String getMessage() {
        return "The status cannot be changed to \"" + this.changeStatus + "\" [currentStatus : \"" + this.currentStatus + "\"]";
    }
}
