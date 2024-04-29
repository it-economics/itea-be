package com.ite.itea.ecommerce.adapters.out.persistence.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "PRODUCT_TYPE")
class ProductTypeDBO {
        @Id
        private Long id;
        private String name;
}
