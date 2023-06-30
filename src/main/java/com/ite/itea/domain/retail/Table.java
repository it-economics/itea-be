package com.ite.itea.domain.retail;

public final class Table extends Product {

    private final long legPriceInCents;
    private final long tableTopPriceInCents;

    public Table(ProductId id, String name, long legPriceInCents, long tableTopPriceInCents) {
        super(id, name);
        this.legPriceInCents = legPriceInCents;
        this.tableTopPriceInCents = tableTopPriceInCents;
    }

    @Override
    public long priceInCents() {
        return 4 * legPriceInCents + tableTopPriceInCents;
    }
}
