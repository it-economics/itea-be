package com.ite.itea.domain.retail;

import com.ite.itea.domain.core.EuroPrice;

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
}
