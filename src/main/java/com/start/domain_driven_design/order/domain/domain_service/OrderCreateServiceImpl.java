package com.start.domain_driven_design.order.domain.domain_service;

import com.start.domain_driven_design.common.annotation.DomainService;
import com.start.domain_driven_design.common.domain.Money;
import com.start.domain_driven_design.order.controller.dto.*;
import com.start.domain_driven_design.order.domain.*;
import com.start.domain_driven_design.order.infra.repository.OrderRepository;
import com.start.domain_driven_design.product.domain.Product;
import com.start.domain_driven_design.product.domain_service.ProductFinder;
import com.start.domain_driven_design.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
public class OrderCreateServiceImpl implements OrderCreateService{

    private final OrderRepository orderRepository;
    private final ProductFinder productFinder;


    // TODO: 상품 주문 구현 해야함
    @Override
    @Transactional
    public OrderResult createOrder(OrderRequest request) {

        ShippingInfo shippingInfo = convertShippingInfo(request.getShippingInfo());

        List<OrderProduct> orderProducts = convertOrderProducts(request.getOrderProducts());

        Orderer orderer = new Orderer(request.getOrderUserId());

        Order order = new Order(new OrderNumber(UUID.randomUUID().toString()), orderer, shippingInfo, orderProducts);

        Order saveOrder = orderRepository.save(order);
        return new OrderResult(saveOrder.getId(), saveOrder.getOrderId().getOrderId());
    }

    private List<OrderProduct> convertOrderProducts(List<OrderProductRequest> orderProductRequests) {
        List<Long> productIds = orderProductRequests.stream().filter(Objects::nonNull).map(OrderProductRequest::getProductId).toList();
        Map<Long, Product> productMap = productFinder.findProductByIdIn(productIds).stream().collect(Collectors.toMap(Product::getId, Function.identity()));

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductRequest orderProductRequest : orderProductRequests) {
            Product product = Optional.ofNullable(productMap.get(orderProductRequest.getProductId())).orElseThrow(() -> new ProductNotFoundException(orderProductRequest.getProductId()));
            OrderProduct orderProduct = new OrderProduct(product.getId(), product.getPrice(), orderProductRequest.getQuantity());
            orderProducts.add(orderProduct);
            product.payment(orderProductRequest.getQuantity());
        }

        return orderProducts;
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
