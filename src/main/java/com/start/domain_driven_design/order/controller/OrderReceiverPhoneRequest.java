package com.start.domain_driven_design.order.controller;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderReceiverPhoneRequest {

    @NotNull
    private String phoneNumber;
}
