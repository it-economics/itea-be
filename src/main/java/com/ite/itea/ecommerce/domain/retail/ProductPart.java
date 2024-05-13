package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

public record ProductPart(EuroPrice price, Integer quantity, String name) {
}
