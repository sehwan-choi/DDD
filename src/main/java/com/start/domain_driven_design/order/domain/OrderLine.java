package com.start.domain_driven_design.order.domain;

import com.start.domain_driven_design.common.domain.Money;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private Money totalPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderLine")
    private List<OrderProduct> orderProductList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    public OrderLine(Order order, List<OrderProduct> orderProductList) {
        this.order = order;
        this.orderProductList = orderProductList;
    }
}
