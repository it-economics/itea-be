package com.ite.itea.ecommerce.domain.retail;

public class Voucher {

    private final EuroPrice discountAmount;

    private Voucher(EuroPrice discountAmount) {
        this.discountAmount = discountAmount;
    }

    public static Voucher ofValue(EuroPrice discountValue) {
        return new Voucher(discountValue);
    }

    public EuroPrice discountAmount() {
        return discountAmount;
    }
}
