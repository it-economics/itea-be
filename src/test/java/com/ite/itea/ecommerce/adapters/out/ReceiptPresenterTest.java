package com.ite.itea.ecommerce.adapters.out;

import com.ite.itea.ecommerce.adapters.out.presenter.ReceiptPresenter;
import com.ite.itea.ecommerce.domain.core.EuroPrice;
import com.ite.itea.ecommerce.domain.retail.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiptPresenterTest {

    private final ReceiptPresenter receiptPresenter = new ReceiptPresenter();

    private static Stream<Arguments> provideProductsAndExpectedReceipts() {
        return Stream.of(
                Arguments.of(
                        Order.of(),
                        EuroPrice.zero(),
                        "itea \nTotal 0,00\u00A0€"
                ),
                Arguments.of(
                        Order.of(
                                new Order.OrderItem(
                                        new Picture(ProductId.random(), "Picture \"Norway\"", EuroPrice.ofCents(999)),
                                        2
                                )
                        ),
                        EuroPrice.ofCents(1998L),
                        "itea \nPicture \"Norway\" 9,99\u00A0€ * 2\nTotal 19,98\u00A0€"
                ),
                Arguments.of(
                        Order.of(
                                new Order.OrderItem(
                                        new Chair(ProductId.random(), "Chair \"Olaf\"", EuroPrice.ofCents(500), EuroPrice.ofCents(500), EuroPrice.ofCents(500)),
                                        2
                                )
                        ),
                        EuroPrice.ofCents(6000L),
                        "itea \nChair \"Olaf\" 30,00\u00A0€ * 2\nTotal 60,00\u00A0€"
                ),
                Arguments.of(
                        Order.of(
                                new Order.OrderItem(
                                        new Table(ProductId.random(), "Table \"Lola\"", EuroPrice.ofCents(2000), EuroPrice.ofCents(5000)),
                                        2
                                )
                        ),
                        EuroPrice.ofCents(26000L),
                        "itea \nTable \"Lola\" 130,00\u00A0€ * 2\nTotal 260,00\u00A0€"
                ),
                Arguments.of(
                        Order.of(
                                new Order.OrderItem(
                                        new Wardrobe(ProductId.random(), "Wardrobe \"Ingeborg\"", EuroPrice.ofEurosAndCents(249, 99)),
                                        2
                                )
                        ),
                        EuroPrice.ofEurosAndCents(499, 98),
                        "itea \nWardrobe \"Ingeborg\" 249,99\u00A0€ * 2\nTotal 499,98\u00A0€"
                ),
                Arguments.of(
                        Order.of(
                                new Order.OrderItem(
                                        new Closet(ProductId.random(), "A closet", EuroPrice.ofEurosAndCents(127, 69)),
                                        3
                                )
                        ),
                        EuroPrice.ofEurosAndCents(383, 07),
                        "itea \nA closet 127,69\u00A0€ * 3\nTotal 383,07\u00A0€"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideProductsAndExpectedReceipts")
    void shouldReturnCorrectReceipts(Order order, EuroPrice expectedTotalPrice, String expectedReceiptText) {
        var receipt = receiptPresenter.prepareReceipt(order);

        assertThat(receipt.priceInCents()).isEqualTo(expectedTotalPrice.asCents());
        assertThat(receipt.text()).isEqualTo(expectedReceiptText);
    }
}
