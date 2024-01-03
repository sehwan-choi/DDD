package com.start.domain_driven_design.product.service;

import com.start.domain_driven_design.common.annotation.DomainService;
import com.start.domain_driven_design.product.domain.Product;
import com.start.domain_driven_design.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class ProductFinder {

    private final ProductRepository productRepository;

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findProductByIdIn(Collection<Long> ids) {
        return productRepository.findByIdIn(ids);
    }
}
