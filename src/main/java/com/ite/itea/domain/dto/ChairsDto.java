package com.ite.itea.domain.dto;

public class ChairsDto extends ItemDto {


    private final long chairbackPrice;
    private final int legAmount;
    private final Material material;
    private final long legPrice;
    private final long platePrice;


    public ChairsDto(long legPrice, long platePrice, long chairbackPrice, int legAmount, Material material) {
        this.chairbackPrice = chairbackPrice;
        this.material = material;
        this.legAmount = legAmount;
        this.legPrice = legPrice;
        this.platePrice = platePrice;
    }

    public long getPriceInCents(int amount) {
        return amount * (legAmount * legPrice + chairbackPrice + platePrice);
    }

    @Override
    public String getName() {
        return "Chair";
    }

}
