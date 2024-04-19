package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

public final class Chair extends Product {

    private final EuroPrice legPrice;
    private final EuroPrice seatPrice;
    private final EuroPrice backRestPrice;

    public Chair(ProductId id, String name, String imageName, EuroPrice legPrice, EuroPrice seatPrice, EuroPrice backRestPrice) {
        super(id, name, imageName);
        this.legPrice = legPrice;
        this.seatPrice = seatPrice;
        this.backRestPrice = backRestPrice;
    }

    @Override
    public EuroPrice price() {
        return legPrice.times(4).plus(seatPrice).plus(backRestPrice);
    }
}
