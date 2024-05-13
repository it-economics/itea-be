package com.ite.itea.ecommerce.adapters.out.persistence.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PartDBO {
    public int count;
    public BigDecimal price;
    public String name;
}
