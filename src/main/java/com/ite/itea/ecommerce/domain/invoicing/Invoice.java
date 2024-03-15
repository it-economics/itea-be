package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.util.ArrayList;
import java.util.List;

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
        return lineItems.parallelStream()
                .map(LineItem::netPrice)
                .reduce(EuroPrice::plus)
                .orElse(EuroPrice.zero());
    }
}
