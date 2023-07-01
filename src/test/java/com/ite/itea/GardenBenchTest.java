package com.ite.itea;

import com.ite.itea.domain.core.EuroPrice;
import com.ite.itea.domain.retail.GardenBench;
import com.ite.itea.domain.retail.ProductId;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GardenBenchTest {

    private static Stream<Arguments> provideGardenBenchConfigurationsWithRespectivePriceAndDescription() {
        return Stream.of(
                Arguments.of(
                        new GardenBench(ProductId.random(), 1, 165, 2, 0, false, false),
                        EuroPrice.ofCents(23000),
                        """
                                Order for a garden bench:
                                Elements: 0 of 2 elements is a plant element, has no backrest
                                Total length: 181 cm
                                Delivery Type: Product is collected for 0.0 EUR
                                Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR
                                """
                ),
                Arguments.of(
                        new GardenBench(ProductId.random(), 1, 165, 2, 0, false, true),
                        EuroPrice.ofCents(30000),
                        """
                                Order for a garden bench:
                                Elements: 0 of 2 elements is a plant element, has no backrest
                                Total length: 181 cm
                                Delivery Type: Product is delivered for 70.0 EUR
                                Total price (without delivery): 1 * 230.0 EUR = 230.0 EUR
                                """
                ),
                Arguments.of(
                        new GardenBench(ProductId.random(), 2, 165, 2, 0, false, false),
                        EuroPrice.ofCents(46000),
                        """
                                Order for a garden bench:
                                Elements: 0 of 2 elements is a plant element, has no backrest
                                Total length: 181 cm
                                Delivery Type: Product is collected for 0.0 EUR
                                Total price (without delivery): 2 * 230.0 EUR = 460.0 EUR
                                """
                ),
                Arguments.of(
                        new GardenBench(ProductId.random(), 1, 165, 1, 1, false, false),
                        EuroPrice.ofCents(28000),
                        """
                                Order for a garden bench:
                                Elements: 1 of 2 elements is a plant element, has no backrest
                                Total length: 225 cm
                                Delivery Type: Product is collected for 0.0 EUR
                                Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR
                                """
                ),
                Arguments.of(
                        new GardenBench(ProductId.random(), 1, 165, 2, 0, true, false),
                        EuroPrice.ofCents(28000),
                        """
                                Order for a garden bench:
                                Elements: 0 of 2 elements is a plant element, has a backrest
                                Total length: 181 cm
                                Delivery Type: Product is collected for 0.0 EUR
                                Total price (without delivery): 1 * 280.0 EUR = 280.0 EUR
                                """
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideGardenBenchConfigurationsWithRespectivePriceAndDescription")
    void shouldProvideCorrectPriceAndDescription(GardenBench gardenBench, EuroPrice expectedPrice, String description) {
        assertThat(gardenBench.price()).isEqualTo(expectedPrice);
        assertThat(gardenBench.description()).isEqualTo(description);
    }
}
