package com.start.domain_driven_design.product.service;

import com.start.domain_driven_design.common.annotation.DomainService;
import com.start.domain_driven_design.product.domain.Product;
import com.start.domain_driven_design.product.exception.ProductNotFoundException;
import com.start.domain_driven_design.product.repository.ProductRepository;
import jakarta.persistence.LockModeType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
public class ProductPayment {

    private final ProductRepository productRepository;

    @Lock(LockModeType.OPTIMISTIC)
    @Transactional
    public void paymentProduct(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        product.payment(quantity);
    }
}
