package com.ite.itea.persistence;

import com.ite.itea.domain.core.EuroPrice;
import com.ite.itea.domain.retail.*;

import java.util.Map;
import java.util.Optional;

import static java.util.Map.entry;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> fakeInMemoryDatabase =
            Map.ofEntries(
                    entry(
                            ProductName.PictureFinland.name(),
                            new Picture(
                                    new ProductId(ProductName.PictureFinland.name()),
                                    ProductName.PictureFinland.name(),
                                    EuroPrice.ofCents(1499)
                            )
                    ),
                    entry(
                            ProductName.PictureNorway.name(),
                            new Picture(
                                    new ProductId(ProductName.PictureNorway.name()),
                                    ProductName.PictureNorway.name(),
                                    EuroPrice.ofCents(999)
                            )
                    ),
                    entry(
                            ProductName.PictureSweden.name(),
                            new Picture(
                                    new ProductId(ProductName.PictureSweden.name()),
                                    ProductName.PictureSweden.name(),
                                    EuroPrice.ofCents(1299)
                            )
                    ),
                    entry(
                            ProductName.TableLola.name(),
                            new Table(
                                    new ProductId(ProductName.TableLola.name()),
                                    ProductName.TableLola.name(),
                                    EuroPrice.ofCents(3000),
                                    EuroPrice.ofCents(1000)
                            )
                    ),
                    entry(
                            ProductName.TableLotta.name(),
                            new Table(
                                    new ProductId(ProductName.TableLotta.name()),
                                    ProductName.TableLotta.name(),
                                    EuroPrice.ofCents(1000),
                                    EuroPrice.ofCents(1000)
                            )
                    ),
                    entry(
                            ProductName.ChairElsa.name(),
                            new Chair(
                                    new ProductId(ProductName.ChairElsa.name()),
                                    ProductName.ChairElsa.name(),
                                    EuroPrice.ofCents(500),
                                    EuroPrice.ofCents(500),
                                    EuroPrice.ofCents(500)
                            )
                    ),
                    entry(
                            ProductName.ChairKnut.name(),
                            new Chair(
                                    new ProductId(ProductName.ChairKnut.name()),
                                    ProductName.ChairKnut.name(),
                                    EuroPrice.ofCents(400),
                                    EuroPrice.ofCents(1000),
                                    EuroPrice.ofCents(1500)
                            )
                    ),
                    entry(
                            ProductName.ChairLars.name(),
                            new Chair(
                                    new ProductId(ProductName.ChairElsa.name()),
                                    ProductName.ChairElsa.name(),
                                    EuroPrice.ofCents(200),
                                    EuroPrice.ofCents(2000),
                                    EuroPrice.ofCents(3000)
                            )
                    )
            );

    @Override
    public Optional<Product> byId(ProductId id) {
        return Optional.ofNullable(fakeInMemoryDatabase.getOrDefault(id.internalID(), null));
    }
}
