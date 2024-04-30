package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
        sut.execute();

        Mockito.verify(productRepository).getAll();
    }

}
