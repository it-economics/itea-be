package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.domain.retail.ProductId;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAProductUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    private FindAProductUseCase sut;

    @BeforeEach
    void setUp() {
        sut = new FindAProductUseCase(productRepository);
    }

    @Test
    void shouldGetProductFromRepository() {
        final var resultMock = Optional.of(mock(Product.class));
        when(productRepository.byId(new ProductId("1"))).thenReturn(resultMock);

        assertThat(sut.execute(new ProductId("1"))).isEqualTo(resultMock);
    }
}
