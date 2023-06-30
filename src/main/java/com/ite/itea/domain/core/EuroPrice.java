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
