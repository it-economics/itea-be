package com.ite.itea.ecommerce.adapters.out.persistence;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import com.ite.itea.ecommerce.domain.retail.*;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> entries = List.of(
            new Picture(
                    new ProductId("1"),
                    "Picture \"Finland\"",
                    EuroPrice.ofCents(1499)
            ),
            new Picture(
                    new ProductId("2"),
                    "Picture \"Oslo\"",
                    EuroPrice.ofCents(999)
            ),
            new Picture(
                    new ProductId("3"),
                    "Picture \"Sweden\"",
                    EuroPrice.ofCents(1299)
            ),
            new Table(
                    new ProductId("4"),
                    "Table \"Lola\"",
                    EuroPrice.ofCents(3000),
                    EuroPrice.ofCents(1000)
            ),
            new Table(
                    new ProductId("5"),
                    "Table \"Lotta\"",
                    EuroPrice.ofCents(1000),
                    EuroPrice.ofCents(1000)
            ),
            new Chair(
                    new ProductId("6"),
                    "Chair \"Olaf\"",
                    EuroPrice.ofCents(500),
                    EuroPrice.ofCents(500),
                    EuroPrice.ofCents(500)
            ),
            new Chair(
                    new ProductId("7"),
                    "Chair \"Knut\"",
                    EuroPrice.ofCents(400),
                    EuroPrice.ofCents(1000),
                    EuroPrice.ofCents(1500)
            ),
            new Chair(
                    new ProductId("8"),
                    "Chair \"Lars\"",
                    EuroPrice.ofCents(200),
                    EuroPrice.ofCents(2000),
                    EuroPrice.ofCents(3000)
            ),
            new Wardrobe(
                    new ProductId("9"),
                    "Wardrobe \"Ingeborg\"",
                    EuroPrice.ofEurosAndCents(249, 99)
            ),
            new Closet(
                    new ProductId("10"),
                    "Closet \"Ragnarök\"",
                    EuroPrice.ofEurosAndCents(329, 99)
            )
    );

    @Override
    public Optional<Product> byId(ProductId id) {
        return entries.stream()
                .filter(entry -> entry.id().equals(id))
                .findFirst();
    }
}
