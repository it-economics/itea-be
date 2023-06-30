package com.ite.itea.domain.retail;

public abstract class Product {

    private final ProductId id;
    private final String name;

    public Product(ProductId id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public abstract long priceInCents();
}
