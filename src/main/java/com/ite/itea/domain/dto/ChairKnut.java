package com.ite.itea.domain.dto;

public class ChairKnut extends ChairsDto{
    public ChairKnut() {
        super( 1200L, 1000L, 1500L, 3, Material.WOOD);
    }

    @Override
    public String getName() {
        return "ChairKnut";
    }
}
