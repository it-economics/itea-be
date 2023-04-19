package com.ite.itea.domain.dto;

public class TablesDto extends ItemDto {

    private final int amount;
    private final double legPrice;
    private final double platePrice;

    public TablesDto(int amount, long legPrice, long platePrice) {
        this.amount = amount;
        this.legPrice = legPrice;
        this.platePrice = platePrice;
        setPrice((long) (4 * legPrice + platePrice));
    }

    @Override
    public String getName() {
        return "Table";
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
