package com.ite.itea.application.dto;

import com.ite.itea.domain.retail.ProductName;

public record ItemRequest(ProductName name, int amount, long price) {

}
