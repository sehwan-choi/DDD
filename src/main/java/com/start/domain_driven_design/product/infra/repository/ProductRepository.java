package com.start.domain_driven_design.product.infra.repository;

import com.start.domain_driven_design.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIdIn(Collection<Long> productIds);
}
