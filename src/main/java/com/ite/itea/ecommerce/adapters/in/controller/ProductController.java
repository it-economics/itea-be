package com.ite.itea.ecommerce.adapters.in.controller;

import com.ite.itea.ecommerce.adapters.out.persistence.InMemoryProductRepository;
import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.usecase.GetProductsUseCase;
import com.ite.itea.ecommerce.usecase.dto.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Tag(name = "Product")
public class ProductController {

    private final GetProductsUseCase getProductsUseCase = new GetProductsUseCase(
            new InMemoryProductRepository()
    );

    @Operation(summary = "get products", description = "get products from the data store")
    @ResponseBody
    @GetMapping(path = "/product",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse calculate() {
        final List<Product> products = getProductsUseCase.execute();
        return new ProductResponse(products);
    }
}
