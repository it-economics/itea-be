package com.ite.itea.ecommerce.usecase.dto;

import com.ite.itea.ecommerce.domain.retail.ProductName;

public record ItemRequest(ProductName name, int amount, long price) {

}
