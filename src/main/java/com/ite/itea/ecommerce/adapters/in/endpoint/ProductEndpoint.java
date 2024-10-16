package com.ite.itea.ecommerce.adapters.in.endpoint;

import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.usecase.FindAProductUseCase;
import com.ite.itea.ecommerce.usecase.GetProductsUseCase;
import com.ite.itea.ecommerce.usecase.soapmodel.ProductsResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import jakarta.xml.bind.JAXBElement;

import javax.xml.namespace.QName;
import java.util.Collection;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE = "http://de.soprasteria.css/itea/itea-soap-service";

    private final GetProductsUseCase getProductsUseCase;

    private final FindAProductUseCase findAProductUseCase;

    public ProductEndpoint(GetProductsUseCase getProductsUseCase, FindAProductUseCase findAProductUseCase) {
        this.getProductsUseCase = getProductsUseCase;
        this.findAProductUseCase = findAProductUseCase;
    }

    @Transactional
    @PayloadRoot(namespace = NAMESPACE, localPart = "ProductsRequest")
    @ResponsePayload
    public JAXBElement<ProductsResponse> findAllProducts() {
        final Collection<Product> products = getProductsUseCase.execute();
        ProductsResponse productsResponse = new ProductsResponse();
        productsResponse.getProduct().addAll(products.stream().map( this::mapProduct).toList());
        return new JAXBElement<>(new QName(NAMESPACE, "ProductsResponse"), ProductsResponse.class, productsResponse);
    }

    private com.ite.itea.ecommerce.usecase.soapmodel.Product mapProduct(Product product) {
        com.ite.itea.ecommerce.usecase.soapmodel.Product newProduct = new com.ite.itea.ecommerce.usecase.soapmodel.Product();
        newProduct.setId(product.id().internalID());
        newProduct.setName(product.name());
        newProduct.setDescription(product.name());
        newProduct.setImageName(product.imageName());
        return newProduct;
    }
}
