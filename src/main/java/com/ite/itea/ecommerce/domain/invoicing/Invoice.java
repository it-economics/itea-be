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
        Map<VatRate, LineItem[]> map = new HashMap<>();

        map.put(VatRate.STANDARD, new LineItem[0]);
        map.put(VatRate.REDUCED, new LineItem[0]);

        for (var lineItem : lineItems) {
            if (lineItem.vatRate() == VatRate.STANDARD) {
                var newArray = new LineItem[map.get(VatRate.STANDARD).length + 1];
                System.arraycopy(map.get(VatRate.STANDARD), 0, newArray, 0, map.get(VatRate.STANDARD).length);
                newArray[newArray.length - 1] = lineItem;
                map.put(VatRate.STANDARD, newArray);
            } else if (lineItem.vatRate() == VatRate.REDUCED) {
                var newArray = new LineItem[map.get(VatRate.REDUCED).length + 1];
                System.arraycopy(map.get(VatRate.REDUCED), 0, newArray, 0, map.get(VatRate.REDUCED).length);
                newArray[newArray.length - 1] = lineItem;
                map.put(VatRate.REDUCED, newArray);
            }
        }

        var netPriceForStandardVatItemsInCents = 0;

        for (var lineItem : map.get(VatRate.STANDARD)) {
            for (int i = 0; i < lineItem.quantity().value; i++) {
                final var grossPercent = 100 + getVatRate(VatRate.STANDARD);
                final var vatFactor = BigDecimal.valueOf(grossPercent, 2)
                        .divide(BigDecimal.valueOf(100, 2), RoundingMode.UNNECESSARY);
                final var netPriceInCents = BigDecimal.valueOf(lineItem.unitPriceGross().asCents(), 2)
                        .divide(vatFactor, RoundingMode.HALF_EVEN)
                        .multiply(BigDecimal.valueOf(100));
                netPriceForStandardVatItemsInCents += netPriceInCents.intValue();
            }
        }

        var netPriceForVatReducedItemsInCents = 0;

        for (var lineItem : map.get(VatRate.REDUCED)) {
            for (int i = 0; i < lineItem.quantity().value; i++) {
                final var grossPercent = 100 + getVatRate(VatRate.REDUCED);
                final var vatFactor = BigDecimal.valueOf(grossPercent, 2)
                        .divide(BigDecimal.valueOf(100, 2), RoundingMode.UNNECESSARY);
                final var netPriceInCents = BigDecimal.valueOf(lineItem.unitPriceGross().asCents(), 2)
                        .divide(vatFactor, RoundingMode.HALF_EVEN)
                        .multiply(BigDecimal.valueOf(100));
                netPriceForVatReducedItemsInCents += netPriceInCents.intValue();
            }
        }

        return EuroPrice.ofCents(netPriceForStandardVatItemsInCents + netPriceForVatReducedItemsInCents);
    }

    private int getVatRate(VatRate vatRate) {
        return vatRate == VatRate.STANDARD ? 19 : 7;
    }
}
