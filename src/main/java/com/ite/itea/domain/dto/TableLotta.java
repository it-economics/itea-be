package com.ite.itea.domain.dto;

public class TableLotta extends TablesDto{
    public TableLotta() {
        super( 1000L, 3000L, Material.PLASTIC);
    }

    @Override
    public String getName() {
        return "TableLotta";
    }
}
