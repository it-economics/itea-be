package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

/**
 * An invoiced item, i.e., a good or service at a certain price and quantity.
 */
record LineItem(String description, EuroPrice unitPriceGross, Quantity quantity) {
}
