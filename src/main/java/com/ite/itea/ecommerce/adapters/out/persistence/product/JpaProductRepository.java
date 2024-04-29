package com.ite.itea.ecommerce.adapters.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


interface JpaProductRepository extends JpaRepository<ProductDBO, Long>  {

    Optional<ProductDBO> findOneById(Long id);
}
