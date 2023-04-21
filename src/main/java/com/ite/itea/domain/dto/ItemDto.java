package com.ite.itea.domain.dto;

public abstract class ItemDto {

    private long price;

    public abstract String getName();

    void setPrice(long price) {
        this.price = price;
    }

    public long getPriceInCents() {
        return this.price;
    }

    public abstract long getPriceInCents(int amount);

}
