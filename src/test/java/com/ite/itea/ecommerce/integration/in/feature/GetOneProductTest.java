package com.ite.itea.ecommerce.integration.in.feature;


import com.ite.itea.ecommerce.domain.core.EuroPrice;
import com.ite.itea.ecommerce.usecase.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetOneProductTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnProductSurprise() {
        var surpriseProductId = 11L;
        var response = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/product/" + surpriseProductId, ProductResponse.class);

        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        then(requireNonNull(response.getBody()).product().id().internalID()).isEqualTo(11L);
        then(response.getBody().product().name()).isEqualTo("Surprise");
        then(response.getBody().product().imageName()).isEqualTo("surprise.png");
        then(response.getBody().product().description()).isEqualTo("What it will be?");
        then(response.getBody().product().price()).isEqualTo(EuroPrice.ofCents(2000));
    }

}
