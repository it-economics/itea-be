package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class GetProductsUseCase {

    private final ProductRepository productRepository;

    public GetProductsUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> execute() {
        return productRepository.getAll();
    }
}
