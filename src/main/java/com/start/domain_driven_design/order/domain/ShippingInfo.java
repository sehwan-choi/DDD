package com.start.domain_driven_design.order.domain;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.util.StringUtils;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class ShippingInfo {

    private String message;

    private OrderAddress address;

    private Receiver receiver;

    public ShippingInfo(String message, OrderAddress address, Receiver receiver) {
        this.message = message;
        this.address = address;
        this.receiver = receiver;
    }
}
