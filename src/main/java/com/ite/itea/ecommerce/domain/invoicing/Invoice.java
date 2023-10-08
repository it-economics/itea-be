package com.ite.itea.ecommerce.domain.invoicing;

import java.util.ArrayList;
import java.util.List;

class Invoice {

    private List<LineItem> lineItems = new ArrayList<>();

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
