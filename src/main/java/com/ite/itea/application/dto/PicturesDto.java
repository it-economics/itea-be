package com.ite.itea.application.dto;

import com.ite.itea.domain.retail.ProductName;

public class PicturesDto extends ItemDto {

    private final int amount;
    private final ProductName pictureType;

    public PicturesDto(ProductName pictureType, int amount, Long price) {
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
