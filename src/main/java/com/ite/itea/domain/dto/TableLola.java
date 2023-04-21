package com.ite.itea.domain.dto;

public class TableLola extends TablesDto{
    public TableLola(int amount) {
        super( 2000L, 5000L, Material.WOOD);
    }

    @Override
    public String getName() {
        return "TableLola";
    }
}
