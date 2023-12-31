package com.start.domain_driven_design.order.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderRequest {

    @NotNull
    private Long orderUserId;

    @Valid
    private OrderShippingInfoRequest shippingInfo;

    @Valid
    private List<OrderProductRequest> orderProducts;
}
