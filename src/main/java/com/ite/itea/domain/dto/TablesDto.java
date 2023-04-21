package com.ite.itea.domain.dto;

public class TablesDto extends ItemDto {

    private final long legPrice;
    private final long platePrice;
    private final Material material;

    public TablesDto( long legPrice, long platePrice, Material material) {
        this.legPrice = legPrice;
        this.platePrice = platePrice;
        this.material = material;
    }

    @Override
    public String getName() {
        return "Table";
    }

    public long getPriceInCents(int amount) {
        return amount * (4 * legPrice + platePrice);
    }

}
