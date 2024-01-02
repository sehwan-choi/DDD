package com.start.domain_driven_design.order.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class OrderRequest {

    @NotNull
    private Long orderUserId;

    @Valid
    @NotNull
    private OrderShippingInfoRequest shippingInfo;

    @Valid
    @NotEmpty
    private List<OrderProductRequest> orderProducts;
}
