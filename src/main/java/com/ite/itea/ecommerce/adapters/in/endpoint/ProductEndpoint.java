package com.ite.itea.ecommerce.adapters.in.endpoint;

import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.domain.retail.ProductId;
import com.ite.itea.ecommerce.usecase.FindAProductUseCase;
import com.ite.itea.ecommerce.usecase.soapmodel.ProductRequest;
import com.ite.itea.ecommerce.usecase.soapmodel.ProductResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE = "http://soprasteria.com/css/itea-soap-service";

    private final FindAProductUseCase findAProductUseCase;

    public ProductEndpoint(FindAProductUseCase findAProductUseCase) {
        this.findAProductUseCase = findAProductUseCase;
    }

    @Transactional
    @PayloadRoot(namespace = NAMESPACE, localPart = "ProductRequest")
    @ResponsePayload
    public ProductResponse findProductById(@RequestPayload ProductRequest request) {
        final Optional<Product> product = findAProductUseCase.execute(new ProductId(request.getId()));
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(
                product.map(this::mapProduct).orElse(null)
        );
        return productResponse;
    }

    /**
     * for simplicity we use only mapping for product properties
     * @param product
     * @return
     */
    private com.ite.itea.ecommerce.usecase.soapmodel.Product mapProduct(Product product) {
        com.ite.itea.ecommerce.usecase.soapmodel.Product mappedSoapProduct = new com.ite.itea.ecommerce.usecase.soapmodel.Product();
        mappedSoapProduct.setId(product.id().internalID());
        mappedSoapProduct.setName(product.name());
        mappedSoapProduct.setDescription(product.name());
        mappedSoapProduct.setImageName(product.imageName());
        return mappedSoapProduct;
    }


}
