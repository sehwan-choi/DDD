package com.start.domain_driven_design.order.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
public class OrderShippingInfoRequest {

    @NotNull
    private String message;

    @Valid
    @NotNull
    private OrderAddressRequest address;

    @Valid
    @NotNull
    private OrderReceiverRequest receiver;
}
