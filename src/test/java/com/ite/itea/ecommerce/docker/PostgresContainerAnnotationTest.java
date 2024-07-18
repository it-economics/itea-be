package com.ite.itea.ecommerce.docker;


import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostgresContainerAnnotationTest implements BeforeAllCallback, AfterAllCallback {

    @Container
    private final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    ).withUsername("user")
            .withPassword("password")
            .withDatabaseName("itea");

    @Override
    public void beforeAll(ExtensionContext context)  {
        //start things here
    }

    @Override
    public void afterAll(ExtensionContext context)  {
        //stop things here
    }
}
