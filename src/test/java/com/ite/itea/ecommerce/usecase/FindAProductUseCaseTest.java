package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.domain.retail.ProductId;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        sut.execute(new ProductId("1"));

        Mockito.verify(productRepository).byId(new ProductId("1"));
    }
}
