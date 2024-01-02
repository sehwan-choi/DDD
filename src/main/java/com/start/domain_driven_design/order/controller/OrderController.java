package com.start.domain_driven_design.order.controller;

import com.start.domain_driven_design.common.SimpleResponse;
import com.start.domain_driven_design.order.controller.dto.OrderRequest;
import com.start.domain_driven_design.order.controller.dto.OrderStatusChangeRequest;
import com.start.domain_driven_design.order.domain.OrderStatus;
import com.start.domain_driven_design.order.domain.domain_service.OrderCreateService;
import com.start.domain_driven_design.order.domain.domain_service.OrderResult;
import com.start.domain_driven_design.order.domain.domain_service.OrderStatusChangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCreateService orderCreateService;
    private final OrderStatusChangeService orderStatusChangeService;

    @PostMapping
    public ResponseEntity<OrderResult> order(@Valid @RequestBody OrderRequest request) {
        OrderResult result = orderCreateService.createOrder(request);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{orderId}/payment")
    public ResponseEntity<SimpleResponse> orderStatusPayment(@PathVariable("orderId") Long orderId) {
        orderStatusChangeService.orderStatusChange(orderId, OrderStatus.PAYMENT);
        return ResponseEntity.ok(SimpleResponse.ok());
    }

    @PatchMapping("/{orderId}/preparing")
    public ResponseEntity<SimpleResponse> orderStatusPreparing(@PathVariable("orderId") Long orderId) {
        orderStatusChangeService.orderStatusChange(orderId, OrderStatus.PREPARING);
        return ResponseEntity.ok(SimpleResponse.ok());
    }

    @PatchMapping("/{orderId}/shipping")
    public ResponseEntity<SimpleResponse> orderStatusShipping(@PathVariable("orderId") Long orderId) {
        orderStatusChangeService.orderStatusChange(orderId, OrderStatus.SHIPPING);
        return ResponseEntity.ok(SimpleResponse.ok());
    }

    @PatchMapping("/{orderId}/completed")
    public ResponseEntity<SimpleResponse> orderStatusCompleted(@PathVariable("orderId") Long orderId) {
        orderStatusChangeService.orderStatusChange(orderId, OrderStatus.COMPLETED);
        return ResponseEntity.ok(SimpleResponse.ok());
    }

    @PatchMapping("/{orderId}/canceled")
    public ResponseEntity<SimpleResponse> orderStatusCanceled(@PathVariable("orderId") Long orderId) {
        orderStatusChangeService.orderStatusChange(orderId, OrderStatus.CANCELED);
        return ResponseEntity.ok(SimpleResponse.ok());
    }
}
