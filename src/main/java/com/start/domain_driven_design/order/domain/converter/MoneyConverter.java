package com.start.domain_driven_design.order.domain.converter;

import com.start.domain_driven_design.common.domain.Money;
import jakarta.persistence.AttributeConverter;

public class MoneyConverter implements AttributeConverter<Money, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Money attribute) {
        return attribute.getMoney();
    }

    @Override
    public Money convertToEntityAttribute(Integer dbData) {
        return new Money(dbData);
    }
}
