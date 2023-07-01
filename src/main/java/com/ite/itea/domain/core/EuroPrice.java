package com.ite.itea.domain.core;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public final class EuroPrice {

    private final long cents;

    private EuroPrice(long cents) {
        this.cents = cents;
    }

    public static EuroPrice ofCents(long cents) {
        return new EuroPrice(cents);
    }

    public static EuroPrice zero() {
        return new EuroPrice(0);
    }

    public EuroPrice plus(EuroPrice tableTopPrice) {
        return new EuroPrice(cents + tableTopPrice.cents);
    }

    public EuroPrice times(int i) {
        return new EuroPrice(cents * i);
    }

    public String formatPrice(Locale locale) {
        var currencyFormat = NumberFormat.getCurrencyInstance(locale);
        var decimalPrice = BigDecimal.valueOf(cents).movePointLeft(2);
        return currencyFormat.format(decimalPrice);
    }

    public long asCents() {
        return cents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EuroPrice euroPrice = (EuroPrice) o;
        return cents == euroPrice.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }

    @Override
    public String toString() {
        return formatPrice(Locale.getDefault());
    }
}
