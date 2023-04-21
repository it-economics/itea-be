package com.ite.itea.domain.dto;

public class TableLotta extends TablesDto{
    public TableLotta(int amount) {
        super(amount, 1000L, 3000L, "plastic");
    }

    @Override
    public String getName() {
        return "TableLotta";
    }
}
