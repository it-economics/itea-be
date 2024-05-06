package com.ite.itea.ecommerce.adapters.out.persistence.product;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import com.ite.itea.ecommerce.domain.retail.CustomProduct;
import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.domain.retail.ProductId;
import com.ite.itea.ecommerce.domain.retail.ProductPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaProductRepositoryImplTest {

    @Mock
    private JpaProductDatabaseRepository jpaProductDatabaseRepository;
    private JpaProductRepositoryImpl sut;

    @BeforeEach
    void setUp() {
        sut = new JpaProductRepositoryImpl(jpaProductDatabaseRepository);
    }

    @Test
    void shouldFetchANotExistingProduct() {
        when(jpaProductDatabaseRepository.findOneById(7L)).thenReturn(Optional.empty());
        final var product = sut.byId(new ProductId("7"));

        assertThat(product).isNotPresent();
    }

    @Test
    void shouldFetchOneProductByIdAndMapItToACustomProduct() {
        when(jpaProductDatabaseRepository.findOneById(3L)).thenReturn(Optional.of(buildTestDatabaseProduct()));

        final var product = sut.byId(new ProductId("3"));

        assertThat(product).isPresent();
        assertTestProduct(product.get());
    }

    @Test
    void shouldFetchAllProductsAndMapThemToCustomProducts() {
        when(jpaProductDatabaseRepository.findAll()).thenReturn(List.of(buildTestDatabaseProduct()));

        final var products = sut.getAll();

        assertThat(products).hasSize(1);
        assertTestProduct(products.get(0));
    }

    private void assertTestProduct(Product product) {
        assertThat(product).isInstanceOf(CustomProduct.class);

        final var customProduct = (CustomProduct) product;

        assertAll("Product",
                () -> assertThat(customProduct.id()).isEqualTo(new ProductId("3")),
                () -> assertThat(customProduct.name()).isEqualTo("Product Name"),
                () -> assertThat(customProduct.description()).isEqualTo("Product Description"),
                () -> assertThat(customProduct.imageName()).isEqualTo("Product Image Name"),
                () -> assertThat(customProduct.getProductParts()).containsExactlyInAnyOrder(
                        new ProductPart(EuroPrice.ofCents(250), 2, "Part1 Name"),
                        new ProductPart(EuroPrice.ofCents(500), 3, "Part2 Name")
                )
        );

    }

    private ProductDBO buildTestDatabaseProduct() {
        return ProductDBO.builder()
                .id(3L)
                .name("Product Name")
                .description("Product Description")
                .imageName("Product Image Name")
                .productParts(List.of(
                                ProductPartsDBO.builder()
                                        .productId(3L)
                                        .part(
                                                PartDBO.builder()
                                                        .id(5L)
                                                        .name("Part1 Name")
                                                        .price(BigDecimal.valueOf(2.50))
                                                        .build())
                                        .quantity(2)
                                        .build(),
                                ProductPartsDBO.builder()
                                        .productId(3L)
                                        .part(
                                                PartDBO.builder()
                                                        .id(6L)
                                                        .name("Part2 Name")
                                                        .price(BigDecimal.valueOf(5))
                                                        .build())
                                        .quantity(3)
                                        .build()
                        )
                )
                .productType(
                        ProductTypeDBO.builder()
                                .id(7L)
                                .name("Product Type Name")
                                .build())
                .build();
    }

}
