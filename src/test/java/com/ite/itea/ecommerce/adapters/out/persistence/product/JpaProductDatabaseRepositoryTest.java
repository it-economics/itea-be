package com.ite.itea.ecommerce.adapters.out.persistence.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("h2database")
public class JpaProductDatabaseRepositoryTest {

    @Autowired
    private JpaProductDatabaseRepository jpaProductDatabaseRepository;

    @Test
    void shouldFetchOneProduct() {
        final Optional<ProductDBO> product = jpaProductDatabaseRepository.findOneById(3L);
        assertThat(product).isPresent();
    }

}

