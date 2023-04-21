package com.ite.itea.domain.dto;

public class ChairElsa extends ChairsDto{

    public ChairElsa(int amount) {
        super(amount, 2000L, 500L, 500L, 4, "plastic");
    }

    @Override
    public String getName() {
        return "ChairElsa";
    }
}
