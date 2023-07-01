package com.ite.itea.domain;

import com.ite.itea.application.dto.*;
import com.ite.itea.domain.retail.ProductName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

class CheckoutCalculatorTest {

    private final CheckoutCalculator checkoutCalculator = new CheckoutCalculator();

    private static Stream<Arguments> provideProductsAndExpectedReceipts() {
        return Stream.of(
                Arguments.of(
                        new PicturesDTO(ProductName.PICTURE_NORWAY, 2, 999L),
                        1998L,
                        "itea \nPicture \"Norway\" 9,99\u00A0€ * 2\nTotal 19,98\u00A0€"
                ),
                Arguments.of(
                        new ChairsDTO(ProductName.CHAIR_ELSA, 2, 500, 500, 500, "plastic"),
                        6000L,
                        "itea \nChair \"Elsa\" 30,00\u00A0€ * 2\nTotal 60,00\u00A0€"
                ),
                Arguments.of(
                        new TablesDTO(ProductName.TABLE_LOLA, 2, 2000, 5000, "wood"),
                        26000L,
                        "itea \nTable \"Lola\" 130,00\u00A0€ * 2\nTotal 260,00\u00A0€"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideProductsAndExpectedReceipts")
    void shouldReturnCorrectReceipts(ProductDTO product, long expectedTotalPriceInCents, String expectedReceiptText) {
        var orderDto = OrderDTO.of(product);

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(expectedTotalPriceInCents);
        then(receipt.text()).isEqualTo(expectedReceiptText);
    }

    @Test
    void shouldReturnCorrectReceiptForEmptyOrder() {
        var emptyOrder = OrderDTO.of();

        var receipt = checkoutCalculator.prepareReceipt(emptyOrder);

        then(receipt.priceInCents()).isEqualTo(0L);
        then(receipt.text()).isEqualTo("itea \nTotal 0,00\u00A0€");
    }
}
