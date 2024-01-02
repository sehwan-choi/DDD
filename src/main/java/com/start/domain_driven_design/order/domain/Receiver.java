package com.start.domain_driven_design.order.domain;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.util.StringUtils;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Receiver {

    private String name;

    private ReceiverPhone phone;


    public Receiver(String name, ReceiverPhone phone) {
        assertText(name);
        this.name = name;
        this.phone = phone;
    }

    private void assertText(String text) {
        if (!StringUtils.hasText(text)) {
            throw new IllegalArgumentException();
        }
    }
}
