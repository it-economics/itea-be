package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * An invoiced item, i.e., a good or service at a certain price and quantity.
 */
record LineItem(
        String description,
        EuroPrice unitPriceGross,
        Quantity quantity,
        VatRate vatRate
) {
    EuroPrice netPrice() {
        int sumOfNetPricesInCents = 0;
        for (int i = 0; i < quantity().value; i++) {
            final var grossPercent = 100 + getVatRate(vatRate());
            final var vatFactor = BigDecimal.valueOf(grossPercent, 2)
                    .divide(BigDecimal.valueOf(100, 2), RoundingMode.UNNECESSARY);
            final var netPriceInCents = BigDecimal.valueOf(unitPriceGross().asCents(), 2)
                    .divide(vatFactor, RoundingMode.HALF_EVEN)
                    .multiply(BigDecimal.valueOf(100));
            sumOfNetPricesInCents += netPriceInCents.intValue();
        }
        return EuroPrice.ofCents(sumOfNetPricesInCents);
    }

    private int getVatRate(VatRate vatRate) {
        return switch(vatRate) {
            case COVID_REDUCED -> 5;
            case REDUCED -> 7;
            case STANDARD -> 19;
            case COVID_STANDARD -> 16;
        };
    }
}
