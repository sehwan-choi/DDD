package com.start.domain_driven_design.order.controller.dto;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class OrderAddressRequest {

    @NotNull
    private String street;

    @NotNull
    private String detail;

    @NotNull
    private Integer zipCode;
}
