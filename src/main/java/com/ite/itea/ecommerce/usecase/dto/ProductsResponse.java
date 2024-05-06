package com.ite.itea.ecommerce.usecase.dto;

import com.ite.itea.ecommerce.domain.retail.Product;

import java.util.Collection;

public record ProductsResponse(Collection<Product> products) {

}
