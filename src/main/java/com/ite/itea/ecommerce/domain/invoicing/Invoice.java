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
        var sum = EuroPrice.zero();
        for (var lineItem : lineItems) {
            sum = sum.plus(lineItem.unitPriceGross().times(lineItem.quantity().value));
        }
        return sum;
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
