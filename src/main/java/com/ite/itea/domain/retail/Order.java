package com.ite.itea.domain.retail;

import com.ite.itea.application.dto.ProductDTO;

import java.util.Arrays;
import java.util.List;

public record Order(List<ProductDTO> productDTOs) {

    public static Order of(ProductDTO... products) {
        return new Order(Arrays.asList(products));
    }
}
