package com.ite.itea.domain.retail;

import com.ite.itea.domain.core.EuroPrice;

public final class ShoppingCart {

    public ShoppingCart() {
    }

    public static ShoppingCart empty() {
        return new ShoppingCart();
    }

    public EuroPrice price() {
        return EuroPrice.ofCents(0);
    }
}
