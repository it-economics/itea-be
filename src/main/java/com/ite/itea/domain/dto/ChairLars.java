package com.ite.itea.domain.dto;

public class ChairLars extends ChairsDto{
    public ChairLars() {
        super( 1000L, 2000L, 3000L, 5, Material.METAL);
    }

    @Override
    public String getName() {
        return "ChairLars";
    }
}
