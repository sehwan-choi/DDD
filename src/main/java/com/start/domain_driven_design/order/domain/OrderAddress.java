package com.start.domain_driven_design.order.domain;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.util.StringUtils;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class OrderAddress {

    private String street;

    private String detail;

    private Integer zipCode;

    public OrderAddress(String street, String detail, Integer zipCode) {
        assertText(street);
        assertText(detail);
        assertZipCode(zipCode);

        this.street = street;
        this.detail = detail;
        this.zipCode = zipCode;
    }

    private void assertText(String text) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException();
        }
    }

    private void assertZipCode(Integer zipCode) {
        if (zipCode == null) {
            throw new IllegalArgumentException();
        }
    }
}
