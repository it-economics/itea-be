package com.ite.itea.domain.dto;

public class TableLola extends TablesDto{
    public TableLola(int amount) {
        super(amount, 2000L, 5000L, "wood");
    }

    @Override
    public String getName() {
        return "TableLola";
    }
}
