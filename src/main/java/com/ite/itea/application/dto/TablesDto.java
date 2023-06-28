package com.ite.itea.application.dto;

import com.ite.itea.presentation.request.ItemNameRequest;

public class TablesDto extends ItemDto {

    private final ItemNameRequest tablesType;
    private final int amount;
    private final long legPrice;
    private final long platePrice;
    private String material;

    public TablesDto(ItemNameRequest tablesType, int amount, long legPrice, long platePrice, String material) {
        this.tablesType = tablesType;
        this.amount = amount;
        this.legPrice = legPrice;
        this.platePrice = platePrice;
        this.material = material;
        setPrice((long) (4 * legPrice + platePrice));
    }

    @Override
    public String getName() {
        return tablesType.name();
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
