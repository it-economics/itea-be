package com.ite.itea.ecommerce;

import com.ite.itea.ecommerce.adapters.out.persistence.product.PartDBO;
import com.ite.itea.ecommerce.adapters.out.persistence.product.ProductDBO;
import com.ite.itea.ecommerce.adapters.out.persistence.product.MongoProductRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@OpenAPI31
@OpenAPIDefinition(
        info = @Info(version = "v0.1.0", title = "itea-ecommerce-api")
)
public class IteaApplication implements CommandLineRunner {

    @Autowired
    private MongoProductRepository mongoProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(IteaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        this.mongoProductRepository.deleteAll();

        final ProductDBO chairOlaf = ProductDBO.builder()
                .id("18f164b2-ecec-4eb7-8c3f-1ea4cf6a3a0e")
                .name("Chair \"Olaf\"")
                .imageName("chairOlaf.png")
                .description("description of chair Olaf, its quite beautiful and really comfortable.")
                .parts(Arrays.asList(
                        PartDBO.builder().count(4).price(new BigDecimal("5.00")).name("Leg").build(),
                        PartDBO.builder().count(1).price(new BigDecimal("5.00")).name("Seat").build(),
                        PartDBO.builder().count(1).price(new BigDecimal("5.00")).name("BackRest").build()
                ))
                .build();

        final ProductDBO pictureFinland = ProductDBO.builder()
                .id("2df1845a-55ec-4e39-9b90-7d4dca60c47b")
                .name("Picture \"Finland\"")
                .imageName("pictureFinland.png")
                .description("description of Picture Finland, its really worth seeing.")
                .parts(Collections.singletonList(
                        PartDBO.builder().count(1).price(new BigDecimal("14.99")).name("Picture").build()
                ))
                .build();

        this.mongoProductRepository.saveAll(Arrays.asList(chairOlaf, pictureFinland));
    }
}
