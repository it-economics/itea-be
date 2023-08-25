package com.ite.itea.ecommerce.domain.retail;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    private static Stream<TestCase> provideShoppingCartContentsWithExpectedTotalPrice() {
        return Stream.of(
                new TestCase(
                        "An empty cart has a total price of zero.",
                        List.of(),
                        EuroPrice.zero()
                ),
                new TestCase(
                        "A cart with multiple products has a total price equal to the sum of their prices.",
                        List.of(
                                new Picture(ProductId.random(), "A beautiful picture", EuroPrice.ofCents(1337)),
                                new Picture(ProductId.random(), "An ugly picture", EuroPrice.ofCents(42))
                        ),
                        EuroPrice.ofCents(1379)
                ),
                new TestCase(
                        "A voucher reduces the total price by the respective discount amount.",
                        List.of(
                                new Picture(ProductId.random(), "Picture 1", EuroPrice.ofEurosAndCents(10, 99)),
                                new Picture(ProductId.random(), "Picture 2", EuroPrice.ofEurosAndCents(123, 42))
                        ),
                        List.of(Voucher.ofValue(EuroPrice.ofEurosAndCents(104, 12))),
                        EuroPrice.ofEurosAndCents(30, 29)
                ),
                new TestCase(
                        "Vouchers higher than the sum of the products' prices cannot reduce the total price below 0.",
                        List.of(new Picture(ProductId.random(), "Picture 1", EuroPrice.ofEuros(10))),
                        List.of(Voucher.ofValue(EuroPrice.ofEuros(100))),
                        EuroPrice.zero()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideShoppingCartContentsWithExpectedTotalPrice")
    void shoppingCartContentsResultInCorrectTotalPrice(TestCase testCase) {
        final var cart = ShoppingCart.empty();

        testCase.products.forEach(cart::addProduct);
        testCase.vouchers.forEach(cart::addVoucher);

        assertThat(cart.price())
                .as(testCase.description)
                .isEqualTo(testCase.expectedTotalPrice);
    }

    private record TestCase(
            String description,
            Iterable<Product> products,
            Iterable<Voucher> vouchers,
            EuroPrice expectedTotalPrice
    ) {

        public TestCase(String description, Iterable<Product> products, EuroPrice expectedTotalPrice) {
            this(description, products, List.of(), expectedTotalPrice);
        }
    }
}
