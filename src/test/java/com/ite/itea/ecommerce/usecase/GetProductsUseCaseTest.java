package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.HashSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetProductsUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    private GetProductsUseCase sut;

    @BeforeEach
    void setUp() {
        sut = new GetProductsUseCase(productRepository);
    }

    @Test
    void shouldGetProductFromRepository() {
        final Collection<Product> resultMock = mock(HashSet.class);
        when(productRepository.getAll()).thenReturn(resultMock);

        assertThat(sut.execute()).isEqualTo(resultMock);
    }

}
