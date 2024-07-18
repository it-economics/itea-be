package com.ite.itea.ecommerce.adapters.out.persistence.product;

import com.ite.itea.ecommerce.docker.PostgresContainerProfileTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryDockerExtendedProfile02Test extends PostgresContainerProfileTest {

    @Autowired
    JpaProductDatabaseRepository productDatabaseRepository;

    @Test
    void should_add_a_new_product() {
        RepositoryTestHelper.addProduct77(productDatabaseRepository);
    }
}
