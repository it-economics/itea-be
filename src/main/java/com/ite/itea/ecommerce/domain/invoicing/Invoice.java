package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Invoice {

    private final VatPercentage vatPercentage;
    private final List<LineItem> lineItems = new ArrayList<>();

    Invoice(VatPercentage vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    EuroPrice grossPrice() {
        var sum = EuroPrice.zero();
        for (var lineItem : lineItems) {
            sum = sum.plus(lineItem.unitPriceGross().times(lineItem.quantity().value));
        }
        return sum;
    }

    VatPercentage getVatPercentage() {
        return vatPercentage;
    }

    public Iterable<LineItem> getLineItems() {
        return Collections.unmodifiableList(lineItems);
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }
}
