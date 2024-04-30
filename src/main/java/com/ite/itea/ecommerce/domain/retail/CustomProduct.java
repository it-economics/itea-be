package com.ite.itea.ecommerce.domain.retail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ite.itea.ecommerce.domain.core.EuroPrice;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

public class CustomProduct extends Product {

    @Setter
    @Getter
    @JsonIgnore
    private List<ProductPart> productParts;


    public CustomProduct(ProductId id, String name, String imageName, String description) {
        super(id, name, imageName);
        this.description = description;
    }

    @Override
    public EuroPrice price() {
        if (productParts == null) {
            return EuroPrice.zero();
        } else {
            return productParts.stream()
                    .map(part -> part.price().times(part.quantity()))
                    .reduce(EuroPrice.zero(), EuroPrice::plus);
        }
    }

}
