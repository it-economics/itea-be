package com.ite.itea.application.dto;

import com.ite.itea.domain.retail.ProductName;

public class TablesDTO extends ProductDTO {

    private final ProductName tablesType;
    private final int amount;

    public TablesDTO(ProductName tablesType, int amount, long legPrice, long platePrice, String material) {
        this.tablesType = tablesType;
        this.amount = amount;
        setPrice(4 * legPrice + platePrice);
    }

    @Override
    public String getName() {
        return tablesType.displayName();
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
