package com.ite.itea.ecommerce.adapters.out.persistence.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "PRODUCT")
class ProductDBO {

    @Id
    private Long id;
    private String name;
    private String description;
    private String imageName;

    @OneToMany(mappedBy = "productId")
    private Collection<ProductPartsDBO> productParts;

    @ManyToOne
    private ProductTypeDBO productType;

}
