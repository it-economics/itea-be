package com.ite.itea.ecommerce.domain.invoicing;

public class VatPercentage {

    public final int value;

    private VatPercentage(int value) {
        this.value = value;
    }

    public static VatPercentage of(int value) {
        return new VatPercentage(value);
    }
}
