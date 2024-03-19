package com.ite.itea.ecommerce.usecase.dto;

import com.ite.itea.ecommerce.domain.retail.Product;

import java.util.List;

public record ProductsResponse(List<Product> products) {

}
