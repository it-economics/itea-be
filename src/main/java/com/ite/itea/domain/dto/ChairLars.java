package com.ite.itea.domain.dto;

public class ChairLars extends ChairsDto{
    public ChairLars(int amount) {
        super(amount, 1000L, 2000L, 3000L, 5, "metal");
    }

    @Override
    public String getName() {
        return "ChairLars";
    }
}
