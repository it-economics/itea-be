package com.ite.itea.domain.retail;

public final class Picture extends Product {

    private final long priceInCents;

    public Picture(ProductId id, String name, long priceInCents) {
        super(id, name);
        this.priceInCents = priceInCents;
    }

    @Override
    public long priceInCents() {
        return priceInCents;
    }
}
