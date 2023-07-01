package com.ite.itea;

import com.ite.itea.domain.core.EuroPrice;
import com.ite.itea.domain.retail.GardenBench;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GardenBenchTest {

    private static final GardenBench defaultBench = new GardenBench(1, 165, 2, 0, false, false);
    private static final GardenBench defaultBenchForDelivery = new GardenBench(1, 165, 2, 0, false, true);
    private static final GardenBench twoDefaultBenches = new GardenBench(2, 165, 2, 0, false, false);
    private static final GardenBench onePlantElementBench = new GardenBench(1, 165, 1, 1, false, false);
    private static final GardenBench backRestBench = new GardenBench(1, 165, 2, 0, true, false);

    private static Stream<Arguments> provideGardenBenchConfigurationsAndRespectivePrices() {
        return Stream.of(
                Arguments.of(defaultBench, EuroPrice.ofCents(23000)),
                Arguments.of(defaultBenchForDelivery, EuroPrice.ofCents(30000)),
                Arguments.of(twoDefaultBenches, EuroPrice.ofCents(46000)),
                Arguments.of(onePlantElementBench, EuroPrice.ofCents(28000)),
                Arguments.of(backRestBench, EuroPrice.ofCents(28000))
        );
    }

    private static Stream<Arguments> provideGardenBenchConfigurationsAndRespectiveDescriptions() {
        return Stream.of(
                Arguments.of(defaultBench, "Order for a garden bench:\n" +
                        "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                        "Total length: 181 cm\n" +
                        "Delivery Type: Product is collected for 0.0 EUR\n" +
                        "Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR\n"),
                Arguments.of(defaultBenchForDelivery, "Order for a garden bench:\n" +
                        "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                        "Total length: 181 cm\n" +
                        "Delivery Type: Product is delivered for 70.0 EUR\n" +
                        "Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR\n"),
                Arguments.of(twoDefaultBenches, "Order for a garden bench:\n" +
                        "Elements: 0 of 2 elements is a plant element, has no backrest\n" +
                        "Total length: 181 cm\n" +
                        "Delivery Type: Product is collected for 0.0 EUR\n" +
                        "Total price (without delivery): 2 * 230.0 EUR = 460.0 EUR\n"),
                Arguments.of(onePlantElementBench, "Order for a garden bench:\n" +
                        "Elements: 1 of 2 elements is a plant element, has no backrest\n" +
                        "Total length: 225 cm\n" +
                        "Delivery Type: Product is collected for 0.0 EUR\n" +
                        "Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR\n"),
                Arguments.of(backRestBench, "Order for a garden bench:\n" +
                        "Elements: 0 of 2 elements is a plant element, has a backrest\n" +
                        "Total length: 181 cm\n" +
                        "Delivery Type: Product is collected for 0.0 EUR\n" +
                        "Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR\n")
        );
    }

    @ParameterizedTest
    @MethodSource("provideGardenBenchConfigurationsAndRespectivePrices")
    void shouldCalculateCorrectPrice(GardenBench gardenBench, EuroPrice expectedPrice) {
        assertThat(gardenBench.calculateTotalPrice()).isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @MethodSource("provideGardenBenchConfigurationsAndRespectiveDescriptions")
    void shouldCalculateCorrectPrice(GardenBench gardenBench, String description) {
        assertThat(gardenBench.getProductText()).isEqualTo(description);
    }
}
