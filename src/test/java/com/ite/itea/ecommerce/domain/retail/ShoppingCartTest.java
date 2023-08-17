package com.ite.itea.ecommerce.domain.retail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    private static Stream<ProductsAndExpectedPrice> provideShoppingCartContentsWithExpectedTotalPrice() {
        return Stream.of(
                new ProductsAndExpectedPrice(
                        List.of(),
                        EuroPrice.zero()
                ),
                new ProductsAndExpectedPrice(
                        List.of(
                                new Picture(ProductId.random(), "A beautiful picture", EuroPrice.ofCents(1337)),
                                new Picture(ProductId.random(), "An ugly picture", EuroPrice.ofCents(42))
                        ),
                        EuroPrice.ofCents(1379)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideShoppingCartContentsWithExpectedTotalPrice")
    void shoppingCartContentsResultInCorrectTotalPrice(ProductsAndExpectedPrice productsAndExpectedPrice) {
        final var cart = new ShoppingCart();

        productsAndExpectedPrice.products.forEach(cart::add);

        assertThat(cart.price()).isEqualTo(productsAndExpectedPrice.expectedTotalPrice);
    }

    private record ProductsAndExpectedPrice(Iterable<Product> products, EuroPrice expectedTotalPrice) {
    }
}
