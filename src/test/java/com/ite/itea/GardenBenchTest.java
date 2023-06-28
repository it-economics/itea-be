package com.ite.itea;

import com.ite.itea.domain.GardenBench;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GardenBenchTest {

    @Test
    void shouldReturnCorrectPriceForDefaultBench() {
        GardenBench gardenBench = new GardenBench(1, 165,
                2, 0, false, false);
        Assertions.assertEquals(230, gardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForDefaultBenchForDelivery() {
        GardenBench gardenBench = new GardenBench(1, 165,
                2, 0, false, true);
        Assertions.assertEquals(300, gardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForTwoDefaultBenches() {
        GardenBench gardenBench = new GardenBench(2, 165,
                2, 0, false, false);
        Assertions.assertEquals(460, gardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForOnePlantElementBench() {
        GardenBench gardenBench = new GardenBench(1, 165,
                1, 1, false, false);
        Assertions.assertEquals(280, gardenBench.calculateTotalPrice());
    }

    @Test
    void shouldReturnCorrectPriceForBackrestBench() {
        GardenBench gardenBench = new GardenBench(1, 165,
                2, 0, true, false);
        Assertions.assertEquals(280, gardenBench.calculateTotalPrice());
    }


    @Test
    void shouldReturnCorrectTextForDefaultBench() {
        GardenBench gardenBench = new GardenBench(1, 165,
                2, 0, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR\n";
        Assertions.assertEquals(expectedText, gardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForDefaultBenchForDelivery() {
        GardenBench gardenBench = new GardenBench(1, 165,
                2, 0, false, true);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is delivered for 70.0 EUR\n" +
                "Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR\n";
        Assertions.assertEquals(expectedText, gardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForTwoDefaultBenches() {
        GardenBench gardenBench = new GardenBench(2, 165,
                2, 0, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 2 * 230.0 EUR = 460.0 EUR\n";
        Assertions.assertEquals(expectedText, gardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForOnePlantElementBench() {
        GardenBench gardenBench = new GardenBench(1, 165,
                1, 1, false, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 1 of 2 elements is a plant element, has no backrest\n" +
                "Total length: 225 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR\n";
        Assertions.assertEquals(expectedText, gardenBench.getProductText());
    }

    @Test
    void shouldReturnCorrectTextForBackrestBench() {
        GardenBench gardenBench = new GardenBench(1, 165,
                2, 0, true, false);
        String expectedText = "Order for a garden bench:\n" +
                "Elements: 0 of 2 elements is a plant element, has a backrest\n" +
                "Total length: 181 cm\n" +
                "Delivery Type: Product is collected for 0.0 EUR\n" +
                "Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR\n";
        Assertions.assertEquals(expectedText, gardenBench.getProductText());
    }
}
