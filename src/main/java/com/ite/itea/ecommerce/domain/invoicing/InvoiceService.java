package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

class InvoiceService {

    /**
     * Calculate the total gross price, i.e., including VAT.
     */
    public EuroPrice calculateGrossPrice(Invoice invoice) {
        return invoice.grossPrice();
    }

    /**
     * Calculate the total net price, i.e., before taxes.
     */
    public EuroPrice calculateNetPrice(Invoice invoice) {
        return invoice.netPrice();
    }
}
