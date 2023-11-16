package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class Invoice {

    private final VatPercentage vatPercentage;
    private final List<LineItem> lineItems = new ArrayList<>();

    Invoice(VatPercentage vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    EuroPrice grossPrice() {
        return lineItems.parallelStream()
                .map(lineItem -> lineItem.unitPriceGross().times(lineItem.quantity().value))
                .reduce(EuroPrice::plus)
                .orElse(EuroPrice.zero());
    }

    EuroPrice netPrice() {
        final var grossPriceInCents = grossPrice().asCents();

        final var grossPercent = 100 + vatPercentage.value;
        final var vatFactor = BigDecimal.valueOf(grossPercent, 2)
                .divide(BigDecimal.valueOf(100, 2), RoundingMode.UNNECESSARY);
        final var netPriceInCents = BigDecimal.valueOf(grossPriceInCents, 2)
                .divide(vatFactor, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(100));

        return EuroPrice.ofCents(netPriceInCents.intValue());
    }
}
