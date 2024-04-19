package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

public final class Wardrobe extends Product {

    private final EuroPrice price;

    public Wardrobe(ProductId id, String name, String imageName, EuroPrice price) {
        super(id, name, imageName);
        this.price = price;
    }

    @Override
    public EuroPrice price() {
        return price;
    }
}
