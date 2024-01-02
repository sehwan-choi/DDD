package com.start.domain_driven_design;

import com.start.domain_driven_design.common.domain.Money;
import com.start.domain_driven_design.product.domain.Product;
import com.start.domain_driven_design.product.infra.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DomainDrivenDesignApplication {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DomainDrivenDesignApplication.class, args);
	}

	@PostConstruct
	void init () {
		List<Product> products = List.of(
				new Product("상품1", 20, new Money(24000), 1L),
				new Product("상품2", 10, new Money(15000), 1L),
				new Product("상품3", 5, new Money(11000), 1L),
				new Product("상품4", 1, new Money(35000), 1L),
				new Product("상품5", 0, new Money(9900), 1L),
				new Product("상품6", 100, new Money(19900), 1L),
				new Product("상품7", 60, new Money(10900), 1L),
				new Product("상품8", 12, new Money(12900), 1L),
				new Product("상품9", 6, new Money(18000), 1L),
				new Product("상품10", 3, new Money(5900), 1L)
		);
		productRepository.saveAll(products);
	}

}
