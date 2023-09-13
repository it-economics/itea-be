package com.ite.itea.ecommerce.adapters.out.persistence;

import com.ite.itea.ecommerce.domain.retail.*;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> entries = List.of(
            new Picture(
                    new ProductId("1"),
                    ProductName.PICTURE_FINLAND.displayName(),
                    EuroPrice.ofCents(1499)
            ),
            new Picture(
                    new ProductId("2"),
                    ProductName.PICTURE_NORWAY.displayName(),
                    EuroPrice.ofCents(999)
            ),
            new Picture(
                    new ProductId("3"),
                    ProductName.PICTURE_SWEDEN.displayName(),
                    EuroPrice.ofCents(1299)
            ),
            new Table(
                    new ProductId("4"),
                    ProductName.TABLE_LOLA.displayName(),
                    EuroPrice.ofCents(3000),
                    EuroPrice.ofCents(1000)
            ),
            new Table(
                    new ProductId("5"),
                    ProductName.TABLE_LOTTA.displayName(),
                    EuroPrice.ofCents(1000),
                    EuroPrice.ofCents(1000)
            ),
            new Chair(
                    new ProductId("6"),
                    ProductName.CHAIR_OLAF.displayName(),
                    EuroPrice.ofCents(500),
                    EuroPrice.ofCents(500),
                    EuroPrice.ofCents(500)
            ),
            new Chair(
                    new ProductId("7"),
                    ProductName.CHAIR_KNUT.displayName(),
                    EuroPrice.ofCents(400),
                    EuroPrice.ofCents(1000),
                    EuroPrice.ofCents(1500)
            ),
            new Chair(
                    new ProductId("8"),
                    ProductName.CHAIR_LARS.displayName(),
                    EuroPrice.ofCents(200),
                    EuroPrice.ofCents(2000),
                    EuroPrice.ofCents(3000)
            ),
            new Wardrobe(
                    new ProductId("9"),
                    ProductName.WARDROBE_INGEBORG.displayName(),
                    EuroPrice.ofEurosAndCents(249, 99)
            )
    );

    @Override
    public Optional<Product> byId(ProductId id) {
        return entries.stream()
                .filter(entry -> entry.id().equals(id))
                .findFirst();
    }
}
