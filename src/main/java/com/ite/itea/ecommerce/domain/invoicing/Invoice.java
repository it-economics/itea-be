package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Invoice {

    private final List<LineItem> lineItems = new ArrayList<>();

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
        var sumOfNetPricesInCents = 0;

        for (var lineItem : lineItems) {
            for (int i = 0; i < lineItem.quantity().value; i++) {
                final var grossPercent = 100 + getVatRate(lineItem.vatRate());
                final var vatFactor = BigDecimal.valueOf(grossPercent, 2)
                        .divide(BigDecimal.valueOf(100, 2), RoundingMode.UNNECESSARY);
                final var netPriceInCents = BigDecimal.valueOf(lineItem.unitPriceGross().asCents(), 2)
                        .divide(vatFactor, RoundingMode.HALF_EVEN)
                        .multiply(BigDecimal.valueOf(100));
                sumOfNetPricesInCents += netPriceInCents.intValue();
            }
        }

        return EuroPrice.ofCents(sumOfNetPricesInCents);
    }

    private int getVatRate(VatRate vatRate) {
        return vatRate == VatRate.STANDARD ? 19 : 7;
    }
}
