package com.start.user.domain;

import com.start.user.domain.exception.PhoneNumberInvalidException;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserPhone {

    private String number;

    private String firstNumber;

    private String middleNumber;

    private String lastNumber;

    public UserPhone(String number) {
        assertPhoneNumber(number);
        String[] numbers = splitNumber(number);
        this.number = number;
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
