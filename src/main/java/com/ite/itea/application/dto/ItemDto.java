package com.ite.itea.application.dto;

public abstract class ItemDto {

    private long price;

    public abstract String getName();

    public abstract int getAmount();

    void setPrice(long price) {
        this.price = price;
    }

    public long getPriceInCents() {
        return this.price;
    }

}
