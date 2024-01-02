package com.start.domain_driven_design.order.domain.domain_service;

import com.start.domain_driven_design.common.annotation.DomainService;
import com.start.domain_driven_design.common.domain.Money;
import com.start.domain_driven_design.order.controller.dto.*;
import com.start.domain_driven_design.order.domain.*;
import com.start.domain_driven_design.order.infra.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@DomainService
@RequiredArgsConstructor
public class OrderCreateServiceImpl implements OrderCreateService{

    private final OrderRepository orderRepository;


    // TODO: 상품 주문 구현 해야함
    @Override
    public OrderResult createOrder(OrderRequest request) {

        ShippingInfo shippingInfo = convertShippingInfo(request.getShippingInfo());

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductRequest orderProductRequest : request.getOrderProducts()) {
            OrderProduct orderProduct = new OrderProduct(orderProductRequest.getProductId(), new Money(10000), orderProductRequest.getQuantity());
            orderProducts.add(orderProduct);
        }

        Orderer orderer = new Orderer(request.getOrderUserId());

        Order order = new Order(new OrderNumber(UUID.randomUUID().toString()), orderer, shippingInfo, orderProducts);
        Order saveOrder = orderRepository.save(order);
        return new OrderResult(saveOrder.getId(), saveOrder.getOrderId().getOrderId());
    }

    private ShippingInfo convertShippingInfo(OrderShippingInfoRequest info) {

        OrderAddressRequest addressRequest = info.getAddress();
        OrderAddress orderAddress = new OrderAddress(addressRequest.getStreet(), addressRequest.getDetail(), addressRequest.getZipCode());

        OrderReceiverRequest receiverRequest = info.getReceiver();
        ReceiverPhone receiverPhone = new ReceiverPhone(receiverRequest.getPhoneNumber());
        Receiver receiver = new Receiver(receiverRequest.getName(), receiverPhone);


        return new ShippingInfo(info.getMessage(), orderAddress, receiver);
    }
}
