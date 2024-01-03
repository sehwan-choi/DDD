package com.start.domain_driven_design.order.domain;

import com.start.domain_driven_design.user.exception.PhoneNumberInvalidException;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
public class ReceiverPhone {

    private String phoneNumber;

    private String firstNumber;

    private String middleNumber;

    private String lastNumber;

    public ReceiverPhone(String number) {
        assertPhoneNumber(number);
        String[] numbers = splitNumber(number);
        this.phoneNumber = number;
        this.firstNumber = numbers[0];
        this.middleNumber = numbers[1];
        this.lastNumber = numbers[2];
    }

    private void assertPhoneNumber(String number) {
        String[] numbers = splitNumber(number);

        if (numbers.length != 3) {
            throw new PhoneNumberInvalidException("Phone Number Invalid Error");
        }
    }

    private String[] splitNumber(String number) {
        try {
            return number.split("-");
        } catch (Exception e) {
            throw new PhoneNumberInvalidException("Phone Number Parsing Error", e);
        }
    }
}
