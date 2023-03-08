package com.ite.itea.domain.dto;

public class PicturesDto extends ItemDto {

    private final int amount;

    public PicturesDto(int amount) {
        setPrice(1499L);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
