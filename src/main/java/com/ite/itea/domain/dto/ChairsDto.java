package com.ite.itea.domain.dto;

public class ChairsDto extends TablesDto {

    private final int amount;
    private final long chairbackPrice;
    private final int legAmount;
    private final String material;

    public ChairsDto(int amount, long legPrice, long platePrice, long chairbackPrice, int legAmount, String material) {
        super(amount, legPrice, platePrice, material);
        this.chairbackPrice = chairbackPrice;
        this.amount = amount;
        this.material = material;
        this.legAmount = legAmount;
        setPrice(legAmount * legPrice + chairbackPrice + platePrice);
    }

    public String getName() {
        return "Chair";
    }

    public int getAmount() {
        return amount;
    }

}
