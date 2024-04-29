package com.ite.itea.ecommerce.adapters.out.persistence.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "PRODUCT_PARTS")
class ProductPartsDBO {

    @Id
    private Long productId;

    @Id
    @ManyToOne
    private PartDBO part;

    private Integer quantity;
}
