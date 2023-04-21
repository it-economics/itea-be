package com.ite.itea.domain.dto;

public class ChairElsa extends ChairsDto{

    public ChairElsa() {
        super( 2000L, 500L, 500L, 4, Material.PLASTIC);
    }

    @Override
    public String getName() {
        return "ChairElsa";
    }
}
