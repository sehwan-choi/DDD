package com.start.domain_driven_design.order.domain.domain_service;

import com.start.domain_driven_design.common.annotation.DomainService;
import com.start.domain_driven_design.order.controller.OrderProductRequest;
import com.start.domain_driven_design.order.controller.OrderReceiverRequest;
import com.start.domain_driven_design.order.controller.OrderRequest;
import com.start.domain_driven_design.order.controller.OrderShippingInfoRequest;
import com.start.domain_driven_design.order.domain.*;
import com.start.domain_driven_design.order.infra.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@DomainService
@RequiredArgsConstructor
public class OrderCreateServiceImpl implements OrderCreateService{

    private final OrderRepository orderRepository;


    // TODO: 상품 주문 구현 해야함
    @Override
    public OrderResult createOrder(OrderRequest request) {

//        Optional.ofNullable(request.getShippingInfo()).map(m ->
//                new ShippingInfo(m.getMessage(), new OrderAddress(m.getAddress().getStreet(),m.getAddress().getDetail(), m.getAddress().getZipCode()), new Receiver(m.getReceiver().getName(), new ReceiverPhone(m.getReceiver().getReceiverPhone().getPhoneNumber()))));
//        OrderShippingInfoRequest requestShippingInfo = request.getShippingInfo();
//        OrderAddress requestShippingInfoAddress = requestShippingInfo.getAddress();
//        OrderReceiverRequest requestReceiver = requestShippingInfo.getReceiver();
//        ShippingInfo shippingInfo = new ShippingInfo(requestShippingInfo.getMessage(), new OrderAddress(requestShippingInfoAddress.getStreet(), requestShippingInfoAddress.getDetail(), requestShippingInfoAddress.getZipCode()), new Receiver(requestReceiver.getName(), new ReceiverPhone(requestReceiver.getReceiverPhone().getPhoneNumber())));
//        Orderer orderer = new Orderer(request.getOrderUserId());
//
//
//        new Order(new OrderNumber(UUID.randomUUID().toString()), orderer, shippingInfo, )
    }
}
