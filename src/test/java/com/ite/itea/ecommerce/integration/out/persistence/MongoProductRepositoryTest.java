package com.ite.itea.ecommerce.integration.out.persistence;

import com.ite.itea.ecommerce.adapters.out.persistence.product.PartDBO;
import com.ite.itea.ecommerce.adapters.out.persistence.product.ProductDBO;
import com.ite.itea.ecommerce.adapters.out.persistence.product.MongoProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoProductRepositoryTest {

    @Autowired
    private MongoProductRepository mongoProductRepository;

    @Test
    void shouldFetchOneProduct() {
        final Optional<ProductDBO> product = mongoProductRepository.findById("18f164b2-ecec-4eb7-8c3f-1ea4cf6a3a0e");
        assertThat(product).isPresent();

        assertAll("product",
                () -> assertThat(product.get().getName()).isEqualTo("Chair \"Olaf\""),
                () -> assertThat(product.get().getImageName()).isEqualTo("chairOlaf.png"),
                () -> assertThat(product.get().getDescription()).isEqualTo("description of chair Olaf, its quite beautiful and really comfortable."),
                () -> assertThat(product.get().getParts()).containsExactlyInAnyOrder(
                        new PartDBO(4, new BigDecimal("5.00"), "Leg"),
                        new PartDBO(1, new BigDecimal("5.00"), "Seat"),
                        new PartDBO(1, new BigDecimal("5.00"), "BackRest")
                )
        );

    }

}
