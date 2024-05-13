package com.ite.itea.ecommerce.adapters.out.persistence.product;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.Collection;

@Builder
@Getter

public class ProductDBO {

    @Id
    public String id;

    public String name;
    public String imageName;
    public String description;

    public Collection<PartDBO> parts;

}
