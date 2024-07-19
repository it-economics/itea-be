package com.ite.itea.ecommerce.adapters.out.persistence.product;

import com.ite.itea.ecommerce.docker.WithPostgresContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
    good practice for tests running in parallel:

    Set schema properties in case of parallel running tests.
    Per default @TestContainer tries to reuse containers (disabling reuse is still an experimental feature).

    This can mean, when your flyway initial script runs a bit longer and a second test class reuses the container
    and starts already writing/reading data for test purpose it can lead to conflicts/problems.
 */
@WithPostgresContainer(properties = {
        "spring.datasource.hikari.schema=RepositoryDockerAnnotation01Test",
        "spring.flyway.schemas=RepositoryDockerAnnotation01Test"
})

public class RepositoryDockerAnnotation01Test  {

    @Autowired
    JpaProductDatabaseRepository productDatabaseRepository;

    @Test
    void should_add_a_new_product() {
        RepositoryTestHelper.addProduct77(productDatabaseRepository);
    }
}
