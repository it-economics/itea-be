package com.ite.itea.ecommerce.domain.invoicing;

import java.util.ArrayList;
import java.util.Collections;
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

    public Iterable<LineItem> getLineItems() {
        return Collections.unmodifiableList(lineItems);
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }
}
