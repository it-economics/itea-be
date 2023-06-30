package com.ite.itea.domain.retail;

import com.ite.itea.domain.core.EuroPrice;

public final class Table extends Product {

    private final EuroPrice legPrice;
    private final EuroPrice tableTopPrice;

    public Table(ProductId id, String name, EuroPrice legPrice, EuroPrice tableTopPrice) {
        super(id, name);
        this.legPrice = legPrice;
        this.tableTopPrice = tableTopPrice;
    }

    @Override
    public EuroPrice price() {
        return legPrice.times(4).plus(tableTopPrice);
    }
}
