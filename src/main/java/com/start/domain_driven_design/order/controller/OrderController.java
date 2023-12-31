package com.start.domain_driven_design.order.controller;

import com.start.domain_driven_design.common.CommonResponse;
import com.start.domain_driven_design.order.domain.domain_service.OrderCreateService;
import com.start.domain_driven_design.order.domain.domain_service.OrderResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCreateService orderCreateService;

    @PostMapping
    public CommonResponse<OrderResult> order(@Valid @RequestBody OrderRequest request) {
        OrderResult result = orderCreateService.createOrder(request);
        return new CommonResponse<>(result, true);

    }
}
