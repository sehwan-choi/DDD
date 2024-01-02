package com.start.domain_driven_design.product.domain;

import com.start.domain_driven_design.common.domain.Money;
import com.start.domain_driven_design.order.domain.converter.MoneyConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int quantity;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private Long categoryId;

    @Version
    private Long version;

    public Product(String name, int quantity, Money price, Long categoryId) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
    }

    public void payment(int quantity) {
        decreaseQuantity(quantity);
    }

    private void decreaseQuantity(int quantity) {
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("재고가 부족합니다. 상품 번호 [" + this.getId() + "] 재고 [" + this.quantity + "] 구매 수량 [" + quantity + "]");
        }
        this.quantity -= quantity;
    }
}
