package com.start.domain_driven_design.user.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserAddress {

    private String street;

    private String detail;

    private int zipCode;
}
