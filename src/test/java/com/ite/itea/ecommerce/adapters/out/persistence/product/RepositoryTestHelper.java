package com.ite.itea.ecommerce.adapters.out.persistence.product;

import org.assertj.core.api.Assertions;
import java.util.Optional;

public class RepositoryTestHelper {

    static void addProduct77 (JpaProductDatabaseRepository productDatabaseRepository) {

        final long productId = 77L;

        if (productDatabaseRepository.findById(productId).isPresent()) {
            throw new RuntimeException("Product already exists");
        }

        final ProductDBO product = ProductDBO.builder()
                .id(productId)
                .name("Product 1 ")
                .description("Description 1 ")
                .imageName("imageName.png ")
                .productType(ProductTypeDBO.builder().id(1L).build())
                .build();
        productDatabaseRepository.save(product);

        final Optional<ProductDBO> oProduct = productDatabaseRepository.findOneById(productId);

        Assertions.assertThat(oProduct).isPresent();
        Assertions.assertThat(oProduct.get().getName()).isEqualTo("Product 1 ");
        Assertions.assertThat(oProduct.get().getDescription()).isEqualTo("Description 1 ");
        Assertions.assertThat(oProduct.get().getImageName()).isEqualTo("imageName.png ");
    }
}
