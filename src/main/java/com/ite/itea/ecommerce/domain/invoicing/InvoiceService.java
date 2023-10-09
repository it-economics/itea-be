package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.math.BigDecimal;
import java.math.RoundingMode;

class InvoiceService {

    /**
     * Calculate the total gross price, i.e., including VAT.
     */
    public EuroPrice calculateGrossPrice(Invoice invoice) {
        var sum = EuroPrice.zero();
        for (var lineItem : invoice.getLineItems()) {
            sum = sum.plus(lineItem.unitPriceGross().times(lineItem.quantity().value));
        }
        return sum;
    }

    /**
     * Calculate the total net price, i.e., before taxes.
     */
    public EuroPrice calculateNetPrice(Invoice invoice) {
        final var grossPriceInCents = calculateGrossPrice(invoice).asCents();

        final var grossPercent = 100 + invoice.getVatPercentage().value;
        final var vatFactor = BigDecimal.valueOf(grossPercent, 2)
                .divide(BigDecimal.valueOf(100, 2), RoundingMode.UNNECESSARY);
        final var netPriceInCents = BigDecimal.valueOf(grossPriceInCents, 2)
                .divide(vatFactor, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(100));

        return EuroPrice.ofCents(netPriceInCents.intValue());
    }
}
