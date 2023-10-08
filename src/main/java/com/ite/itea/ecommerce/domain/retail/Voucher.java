package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

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
