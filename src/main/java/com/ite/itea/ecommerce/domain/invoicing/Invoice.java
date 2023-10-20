package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.util.ArrayList;
import java.util.List;

class Invoice {

    private final VatPercentage vatPercentage;
    private final List<LineItem> lineItems = new ArrayList<>();

    Invoice(VatPercentage vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public VatPercentage getVatPercentage() {
        return vatPercentage;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void addLineItems(final LineItem lineItem) {
        lineItems.add(lineItem);
    }

    /**
     * Calculate the total gross price, i.e., including VAT.
     */
    public EuroPrice calculateGrossPrice(){
        var sum = EuroPrice.zero();
        for (var lineItem : this.getLineItems()) {
            sum = sum.plus(lineItem.unitPriceGross().times(lineItem.quantity().value));
        }
        return sum;
    }


}
