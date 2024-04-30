package com.ite.itea.ecommerce.adapters.out.persistence.product;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import com.ite.itea.ecommerce.domain.retail.CustomProduct;
import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.domain.retail.ProductId;
import com.ite.itea.ecommerce.domain.retail.ProductPart;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaProductRepositoryImpl implements ProductRepository {

    private final JpaProductDatabaseRepository jpaProductDatabaseRepository;

    public JpaProductRepositoryImpl(final JpaProductDatabaseRepository jpaProductDbRepository) {
        this.jpaProductDatabaseRepository = jpaProductDbRepository;
    }

    @Override
    public Optional<Product> byId(ProductId id) {
        final Optional<ProductDBO> productDbo = this.jpaProductDatabaseRepository.findOneById(Long.parseLong(id.internalID()));
        return productDbo.flatMap(JpaProductRepositoryImpl::toProduct);
    }
    @Override
    public List<Product> getAll() {
        return this.jpaProductDatabaseRepository.findAll()
                .stream()
                .map(JpaProductRepositoryImpl::toProduct)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private static Optional<Product> toProduct(ProductDBO productDbo) {
        final CustomProduct product = new CustomProduct(
                new ProductId(productDbo.getId().toString()),
                productDbo.getName(),
                productDbo.getImageName(),
                productDbo.getDescription());
        product.setProductParts(productDbo.getProductParts()
                .stream()
                .map(JpaProductRepositoryImpl::toProductPart)
                .collect(Collectors.toList()));
        return Optional.of(product);
    }

    private static ProductPart toProductPart(ProductPartsDBO productPart) {
        final BigDecimal centAmount = productPart.getPart().getPrice().multiply(BigDecimal.valueOf(100), MathContext.UNLIMITED);
        return new ProductPart(
                EuroPrice.ofCents(centAmount.longValue()),
                productPart.getQuantity(),
                productPart.getPart().getName());
    }

}
