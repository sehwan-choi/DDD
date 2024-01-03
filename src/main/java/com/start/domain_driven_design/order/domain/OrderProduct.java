package com.start.domain_driven_design.order.domain;

import com.start.domain_driven_design.common.domain.Money;
import com.start.domain_driven_design.order.converter.MoneyConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    private Long productId;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private int quantity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public OrderProduct(Long productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
