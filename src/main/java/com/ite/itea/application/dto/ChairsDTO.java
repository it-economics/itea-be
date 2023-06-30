package com.ite.itea.application.dto;

import com.ite.itea.domain.retail.ProductName;

public class ChairsDTO extends ProductDTO {

    private final TablesDTO table;

    public ChairsDTO(ProductName chairType, int amount, long legPrice, long platePrice, long backRestPrice, String material) {
        table = new TablesDTO(chairType, amount, legPrice, platePrice, material);
        setPrice(table.getPriceInCents() + backRestPrice);
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
