package com.ite.itea.ecommerce.usecase.port;

import com.ite.itea.ecommerce.domain.retail.Product;
import com.ite.itea.ecommerce.domain.retail.ProductId;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> byId(ProductId id);

    @Deprecated
    Collection<Product> getAll();

    List<Product> getAllSorted();
}
