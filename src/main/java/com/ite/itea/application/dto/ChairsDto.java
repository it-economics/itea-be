package com.ite.itea.application.dto;

import com.ite.itea.domain.retail.ProductName;

public class ChairsDto extends ItemDto {

    private final TablesDto table;
    private long chairbackPrice;

    public ChairsDto(ProductName chairType, int amount, long legPrice, long platePrice, long chairbackPrice, String material) {
        table = new TablesDto(chairType, amount, legPrice, platePrice, material);
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
