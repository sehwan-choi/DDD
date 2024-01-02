package com.start.domain_driven_design.order.controller.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
public class OrderProductRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Integer quantity;
}
