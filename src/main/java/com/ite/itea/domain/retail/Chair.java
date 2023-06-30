package com.ite.itea.domain.retail;

public final class Chair extends Product {

    private final long legPriceInCents;
    private final long seatPriceInCents;
    private final long backRestPriceInCents;

    public Chair(ProductId id, String name, long legPriceInCents, long seatPriceInCents, long backRestPriceInCents) {
        super(id, name);
        this.legPriceInCents = legPriceInCents;
        this.seatPriceInCents = seatPriceInCents;
        this.backRestPriceInCents = backRestPriceInCents;
    }

    @Override
    public long priceInCents() {
        return 4 * legPriceInCents + seatPriceInCents + backRestPriceInCents;
    }
}
