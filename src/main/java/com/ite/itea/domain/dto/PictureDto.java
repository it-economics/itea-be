package com.ite.itea.domain.dto;

public class PictureDto extends ItemDto {

    private final int amount;

    public PictureDto(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
