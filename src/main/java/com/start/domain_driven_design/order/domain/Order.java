package com.start.domain_driven_design.order.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private OrderNumber orderId;

    @Embedded
    private Orderer orderer;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @Embedded
    private ShippingInfo shippingInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private OrderLine orderLine;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order(OrderNumber orderId, Orderer orderUser, ShippingInfo shippingInfo, OrderLine orderLine) {
        this.setOrderId(orderId);
        this.setOrderer(orderUser);
        this.setShippingInfo(shippingInfo);
        this.setOrderLine(orderLine);
    }

    private void setOrderId(OrderNumber orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId is Null");
        }
        this.orderId = orderId;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("orderer is Null");
        }
        this.orderer = orderer;
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("shippingInfo is Null");
        }
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLine(OrderLine orderLine) {
        if (orderLine == null) {
            throw new IllegalArgumentException("orderLine is Null");
        }
        this.orderLine = orderLine;
    }
}
