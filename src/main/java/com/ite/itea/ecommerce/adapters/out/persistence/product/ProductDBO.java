package com.ite.itea.ecommerce.adapters.out.persistence.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import java.util.Set;


@Getter
@Entity
@Table(name = "PRODUCT")
class ProductDBO {

    @Id
    private Long id;
    private String name;
    @Lob
    private String description;
    private String imageName;

    @OneToMany(mappedBy = "productId")
    private Set<ProductPartsDBO> productParts;

    @ManyToOne
    private ProductTypeDBO productType;

}
