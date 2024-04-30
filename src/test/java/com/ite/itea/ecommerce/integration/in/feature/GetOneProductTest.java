package com.ite.itea.ecommerce.integration.in.feature;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.BDDAssertions.then;

@TestPropertySource(properties = {
        "spring.flyway.locations=classpath:db/migration,classpath:db/test_migration"
})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class GetOneProductTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnProductSurprise() {
        var surpriseProductId = 9999L;
        final ResponseEntity<String> response = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/product/" + surpriseProductId, String.class);

        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(response.getBody()).contains("\"id\":{\"internalID\":\"9999\"}");
        then(response.getBody()).contains("\"name\":\"Surprise\"");
        then(response.getBody()).contains("\"imageName\":\"surprise.png\"");
        then(response.getBody()).contains("\"description\":\"What it will be?\"");
        then(response.getBody()).contains("\"price\":{\"cents\":2000}");

    }

}
