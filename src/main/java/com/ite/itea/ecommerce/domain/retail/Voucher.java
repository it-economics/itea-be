package com.ite.itea.ecommerce.domain.retail;

public class Voucher extends Product {

    private final EuroPrice discountAmount;

    private Voucher(EuroPrice discountAmount) {
        super(null, null);
        this.discountAmount = discountAmount;
    }

    public static Voucher ofValue(EuroPrice discountValue) {
        return new Voucher(discountValue);
    }

    public EuroPrice discountAmount() {
        return discountAmount;
    }

    @Override
    public EuroPrice price() {
        throw new UnsupportedOperationException("Vouchers do not have a price, since they are not " +
                "for sale. Instead, they have a discount amount or percentage.");
    }
}
