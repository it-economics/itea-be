package com.ite.itea.domain.dto;

public class PicturesDto extends ItemDto {

    private final int amount;

    public PicturesDto(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
