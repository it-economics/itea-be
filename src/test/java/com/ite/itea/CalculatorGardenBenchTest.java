package com.ite.itea;

import com.ite.itea.domain.CalculatorGardenBench;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorGardenBenchTest {

    @Test
    void shouldReturnCorrectPriceForDefaultBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, false, false);
        Assertions.assertEquals(230, calculatorGardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForDefaultBenchForDelivery() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, false, true);
        Assertions.assertEquals(300, calculatorGardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForTwoDefaultBenches() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(2, 165,
                2, 0, false, false);
        Assertions.assertEquals(460, calculatorGardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForOnePlantElementBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                1, 1, false, false);
        Assertions.assertEquals(280, calculatorGardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForBackrestBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, true, false);
        Assertions.assertEquals(280, calculatorGardenBench.calculateTotalPrice());
    }


    @Test
    void shouldReturnCorrectTextForDefaultBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForDefaultBenchForDelivery() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, false, true);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is delivered for 70.0 EUR\n" +
                "Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForTwoDefaultBenches() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(2, 165,
                2, 0, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 2 * 230.0 EUR = 460.0 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForOnePlantElementBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                1, 1, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 1 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 225 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForBackrestBench() {
        CalculatorGardenBench calculatorGardenBench = new CalculatorGardenBench(1, 165,
                2, 0, true, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has a backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR\n";
        Assertions.assertEquals(expectedText, calculatorGardenBench.getProductText());
    }
}
