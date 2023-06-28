package com.ite.itea.presentation.request;

import com.ite.itea.domain.retail.ProductName;

public record ItemRequest(ProductName name, int amount, long price) {

}
