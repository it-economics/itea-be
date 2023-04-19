package com.ite.itea.domain.dto;

public class ChairsDto extends TablesDto {

    private final int amount;
    private final long chairbackPrice;

    public ChairsDto(int amount, long legPrice, long platePrice, long chairbackPrice) {
        super(amount, legPrice, platePrice);
        this.chairbackPrice = chairbackPrice;
        this.amount = amount;
        setPrice(getPriceInCents() + chairbackPrice);
    }

    public String getName() {
        return "Chair";
    }

    public int getAmount() {
        return amount;
    }

}
