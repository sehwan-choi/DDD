package com.start.domain_driven_design.order.controller;

import com.start.domain_driven_design.order.domain.OrderAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderShippingInfoRequest {

    @NotNull
    private String message;

    @Valid
    private OrderAddress address;

    @Valid
    private OrderReceiverRequest receiver;
}
