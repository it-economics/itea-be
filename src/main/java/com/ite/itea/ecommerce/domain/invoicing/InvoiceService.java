package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

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
}
