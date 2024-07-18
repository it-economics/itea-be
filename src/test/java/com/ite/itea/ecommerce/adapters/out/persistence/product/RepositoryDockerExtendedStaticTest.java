package com.ite.itea.ecommerce.adapters.out.persistence.product;

import com.ite.itea.ecommerce.docker.PostgresStaticContainerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
    If you really want to use a static test container, it might make sense to use a separate schema for each
    test class, to avoid the tests influencing each other.

    see RepositoryDockerAnnotation01Test.java
 */
public class RepositoryDockerExtendedStaticTest extends PostgresStaticContainerTest {

    @Autowired
    JpaProductDatabaseRepository productDatabaseRepository;

    @Test
    void should_add_a_new_product() {
        RepositoryTestHelper.addProduct77(productDatabaseRepository);
    }
}
