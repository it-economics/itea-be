package com.ite.itea.domain.dto;

public class ChairKnut extends ChairsDto{
    public ChairKnut(int amount) {
        super(amount, 1200L, 1000L, 1500L, 3, "wood");
    }

    @Override
    public String getName() {
        return "ChairKnut";
    }
}
