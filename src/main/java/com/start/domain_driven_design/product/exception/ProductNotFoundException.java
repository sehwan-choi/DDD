package com.start.domain_driven_design.product.exception;

public class ProductNotFoundException extends RuntimeException{

    private final Long productId;
    public ProductNotFoundException(Long productId) {
        this.productId = productId;
    }

    @Override
    public String getMessage() {
        return "Product Id \"" +this.productId + "\" is Not found!";
    }
}
