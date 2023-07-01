package com.ite.itea.application.dto;

import java.util.Arrays;
import java.util.List;

public record OrderDTO(List<ProductDTO> productDTOs) {

    public static OrderDTO of(ProductDTO... products) {
        return new OrderDTO(Arrays.asList(products));
    }
}
