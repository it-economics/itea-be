package com.ite.itea.domain.retail;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> byId(ProductId id);
}
