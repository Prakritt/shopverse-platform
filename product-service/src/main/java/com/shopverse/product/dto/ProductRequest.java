package com.shopverse.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String sku;

    @NotNull
    @Min(0)
    private Double price;

    public ProductRequest(){}

    public ProductRequest(String name, String sku, Double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }
}
