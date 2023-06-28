package com.ite.itea.application.dto;

import com.ite.itea.domain.request.ItemNameRequest;

public class PicturesDto extends ItemDto {

    private final int amount;
    private final ItemNameRequest pictureType;

    public PicturesDto(ItemNameRequest pictureType, int amount, Long price) {
        setPrice(price);
        this.pictureType = pictureType;
        this.amount = amount;
    }

    public String getName() {
        return pictureType.name();
    }

    public int getAmount() {
        return amount;
    }

}
