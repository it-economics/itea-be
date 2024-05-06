package com.ite.itea.ecommerce.domain.retail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ite.itea.ecommerce.domain.core.EuroPrice;
import lombok.Getter;
import java.util.Collection;
import java.util.HashSet;

@Getter
public class CustomProduct extends Product {

    @JsonIgnore
    private final Collection<ProductPart> productParts;


    public CustomProduct(ProductId id, String name, String imageName, String description) {
        super(id, name, imageName);
        this.description = description;
        this.productParts = new HashSet<>();
    }

    @Override
    public EuroPrice price() {
        return productParts.stream()
                .map(part -> part.price().times(part.quantity()))
                .reduce(EuroPrice.zero(), EuroPrice::plus);
    }

    public void addProductParts(Collection<ProductPart> productParts) {
        this.productParts.addAll(productParts);
    }

}
