package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

public final class Closet extends Product {

    private final EuroPrice price;

    public Closet(ProductId id, String name, String imageName, EuroPrice price) {
        super(id, name, imageName);
        this.price = price;
    }

    @Override
    public EuroPrice price() {
        return price;
    }
}
