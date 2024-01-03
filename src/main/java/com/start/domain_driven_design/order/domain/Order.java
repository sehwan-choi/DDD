package com.start.domain_driven_design.order.domain;

import com.start.domain_driven_design.order.exception.OrderStatusChangeException;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Order(OrderNumber orderId, Orderer orderUser, ShippingInfo shippingInfo, List<OrderProduct> orderProducts) {
        this.setOrderId(orderId);
        this.setOrderer(orderUser);
        this.setShippingInfo(shippingInfo);
        this.orderProducts = orderProducts;
        this.status = OrderStatus.BEFORE_PAYMENT;
    }

    public void statusChange(OrderStatus status) {
        if (!this.status.isAvailableStatus(status)) {
            throw new OrderStatusChangeException(this.status.name(), status.name());
        }
        this.status = status;
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
}
