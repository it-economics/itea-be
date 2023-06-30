package com.ite.itea.domain.core;

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
}
