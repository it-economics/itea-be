package com.ite.itea.ecommerce.adapters.out.persistence.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductRepository extends MongoRepository<ProductDBO, String> {
}
