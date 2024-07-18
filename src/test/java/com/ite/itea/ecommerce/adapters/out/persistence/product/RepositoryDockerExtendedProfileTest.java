package com.ite.itea.ecommerce.adapters.out.persistence.product;

import com.ite.itea.ecommerce.docker.PostgresContainerProfileTest;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RepositoryDockerExtendedProfileTest extends PostgresContainerProfileTest {

    @Autowired
    JpaProductDatabaseRepository productDatabaseRepository;

    @SneakyThrows
    @Test
    void should_add_a_new_product() {

        final ProductDBO product = ProductDBO.builder()
                .id(77L)
                .name("Product 1")
                .description("Description 1")
                .imageName("imageName.png")
                .productType(ProductTypeDBO.builder().id(1L).build())
                .build();
        productDatabaseRepository.save(product);

        final Optional<ProductDBO> oProduct = productDatabaseRepository.findOneById(77L);

        Assertions.assertThat(oProduct).isPresent();
        Assertions.assertThat(oProduct.get().getName()).isEqualTo("Product 1");
        Assertions.assertThat(oProduct.get().getDescription()).isEqualTo("Description 1");
        Assertions.assertThat(oProduct.get().getImageName()).isEqualTo("imageName.png");
    }
}
