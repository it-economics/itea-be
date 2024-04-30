package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CustomProductTest {

    @Test
    void shouldCalculatePrice() {
        final var product = buildCustomProduct();
        product.setProductParts(List.of(
                buildProductPart(EuroPrice.ofCents(100), 1),
                buildProductPart(EuroPrice.ofCents(200), 2),
                buildProductPart(EuroPrice.ofCents(500), 3)
        ));

        assertThat(product.price()).isEqualTo(EuroPrice.ofCents(2000));
    }

    @Test
    void shouldCalculateZeroPriceWhenNoProductPartsExisting() {
        final var product = buildCustomProduct();
        assertThat(product.price()).isEqualTo(EuroPrice.zero());
    }


    @Test
    void shouldCalculateZeroPriceWhenProductPartsEmpty() {
        final var product = buildCustomProduct();
        product.setProductParts(Collections.emptyList());
        assertThat(product.price()).isEqualTo(EuroPrice.zero());
    }

    private CustomProduct buildCustomProduct() {
        return new CustomProduct(new ProductId("1"), "name", "imageName", "description");
    }
    private ProductPart buildProductPart(EuroPrice price, int quantity) {
        return new ProductPart( price, quantity, "name");
    }

}
