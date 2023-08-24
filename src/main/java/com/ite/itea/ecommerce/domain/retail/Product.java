package com.ite.itea.ecommerce.domain.retail;

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

    public String description() {
        // Empty by default, but subclasses can override.
        return "";
    }

    public abstract EuroPrice price();

    @Override
    public String toString() {
        return "Product { %s }".formatted(name);
    }
}
