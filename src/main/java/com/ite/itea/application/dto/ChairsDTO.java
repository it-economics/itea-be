package com.ite.itea.application.dto;

import com.ite.itea.domain.retail.ProductName;

public class ChairsDTO extends ProductDTO {

    private final TablesDTO table;
    private long chairbackPrice;

    public ChairsDTO(ProductName chairType, int amount, long legPrice, long platePrice, long chairbackPrice, String material) {
        table = new TablesDTO(chairType, amount, legPrice, platePrice, material);
        this.chairbackPrice = chairbackPrice;
        setPrice(table.getPriceInCents() + chairbackPrice);
    }

    @Override
    public String getName() {
        return table.getName();
    }

    @Override
    public int getAmount() {
        return table.getAmount();
    }
}
