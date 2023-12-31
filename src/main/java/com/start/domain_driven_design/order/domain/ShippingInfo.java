package com.start.domain_driven_design.order.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class ShippingInfo {

    private String message;

    private OrderAddress address;

    private Receiver receiver;
}
