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
        return lineItems.stream()
                .map(lineItem -> lineItem.unitPriceGross().times(lineItem.quantity().value))
                .reduce(EuroPrice.zero(), EuroPrice::plus);
    }

    EuroPrice netPrice() {
        EuroPrice res = EuroPrice.zero();
        for (LineItem lit : lineItems) {
            EuroPrice netPrice = lit.netPrice();
            res = res.plus(netPrice);
        }
        return res;
    }
}
