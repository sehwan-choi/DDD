package com.start.domain_driven_design.order.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class OrderAddress {

    @NotNull
    private String street;

    @NotNull
    private String detail;

    @NotNull
    private int zipCode;
}
