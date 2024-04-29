package com.ite.itea.ecommerce.adapters.out.persistence.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "PART")
class PartDBO {

    @Id
    private Long id;
    private String name;
    private BigDecimal price;
}
