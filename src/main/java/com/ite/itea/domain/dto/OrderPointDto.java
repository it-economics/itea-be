package com.ite.itea.domain.dto;

public class OrderPointDto {

    public final int amount;

    public final ItemDto item;

    public OrderPointDto(int amount, ItemDto item){
        this.amount = amount;
        this.item = item;
    }

    public int getAmount(){
        return this.amount;
    }

    public ItemDto getItem() {
        return item;
    }
}
