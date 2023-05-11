package com.ite.itea;

import com.ite.itea.domain.CalculatorGardenBench;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import java.math.BigDecimal;

public class CalculatorGardenBenchTest {


    @ParameterizedTest
    @MethodSource("provideBenchConfigurationsWithPrice")
    void shouldReturnCorrectPriceForConfiguration(CalculatorGardenBench calculatorGardenBench, BigDecimal price) {
        Assertions.assertEquals(price, calculatorGardenBench.getTotalPrice());
    }

    @Test
    void shouldReturnCorrectTextForDefaultBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0 EUR\n" +
                "Total price (without delivery): 1 * 230 EUR = 230 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForDefaultBenchForDelivery() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, false, true);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is delivered for 70 EUR\n" +
                "Total price (without delivery): 1 * 230 EUR = 230 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForTwoDefaultBenches() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(2, 165,
                2, 0, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0 EUR\n" +
                "Total price (without delivery): 2 * 230 EUR = 460 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForOnePlantElementBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                1, 1, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 1 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 225 cm\n" +
                "Delivery Type: Product is collected for 0 EUR\n" +
                "Total price (without delivery): 1 * 280 EUR = 280 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForBackrestBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, true, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has a backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0 EUR\n" +
                "Total price (without delivery): 1 * 280 EUR = 280 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    private static Stream<Arguments> provideBenchConfigurationsWithPrice() {
        return Stream.of(
                // 1:
                Arguments.of(new CalculatorGardenBench(1,
                                165,
                                2,
                                0,
                                false,
                                false),
                        new BigDecimal(230)),
                // 2:
                Arguments.of(new CalculatorGardenBench(1,
                                165,
                                2,
                                0,
                                false,
                                true),
                        new BigDecimal(300)),
                // 3:
                Arguments.of(new CalculatorGardenBench(2,
                                165,
                                2,
                                0,
                                false,
                                true),
                        new BigDecimal(590)),
                // 4:
                Arguments.of(new CalculatorGardenBench(1,
                        165,
                        1,
                        1,
                        false,
                        true),
                        new BigDecimal(360)),
                // 5:
                Arguments.of(new CalculatorGardenBench(1,
                        165,
                        2,
                        0,
                        true,
                        true),
                        new BigDecimal(350)),
                // 6:
                Arguments.of(new CalculatorGardenBench(1,
                                210,
                                2,
                                0,
                                true,
                                true),
                        new BigDecimal(425)),
                // 7:
                Arguments.of(new CalculatorGardenBench(1,
                                165,
                                0,
                                2,
                                true,
                                true),
                        new BigDecimal(470)),
                // 8:
                Arguments.of(new CalculatorGardenBench(1,
                                210,
                                1,
                                1,
                                false,
                                true),
                        new BigDecimal(435)),
                // 9:
                Arguments.of(new CalculatorGardenBench(1,
                                210,
                                0,
                                2,
                                false,
                                true),
                        new BigDecimal(495))
                );
    }
}
