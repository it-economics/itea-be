package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

public final class Table extends Product {

    private final EuroPrice legPrice;
    private final EuroPrice tableTopPrice;

    public Table(ProductId id, String name, String imageName, EuroPrice legPrice, EuroPrice tableTopPrice) {
        super(id, name, imageName);
        this.legPrice = legPrice;
        this.tableTopPrice = tableTopPrice;
    }

    @Override
    public EuroPrice price() {
        return legPrice.times(4).plus(tableTopPrice);
    }
}
