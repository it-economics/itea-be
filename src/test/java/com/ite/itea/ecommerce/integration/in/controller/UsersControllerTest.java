package com.ite.itea.ecommerce.integration.in.controller;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"management.port=0"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsersControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @ParameterizedTest
    @CsvSource("""
            52be6639-8e24-4bdc-84e6-bda07a9aaaf0, Full name: John Wick
            """)
    void shouldReturnCorrectFullName(String userId, String expectedFullName) {
        final var hostUrl = "http://localhost:" + this.port;
        final var endpointPath = "/user/%s/fullname".formatted(userId);
        final var responseEntity = this.testRestTemplate.getForEntity(hostUrl + endpointPath, String.class);

        then(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(responseEntity.getBody()).isEqualTo(expectedFullName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"not_a_user_id_that_exists"})
    void shouldReturnStatus404ForUnknownUserId(String nonExistentUserId) {
        final var hostUrl = "http://localhost:" + this.port;
        final var endpointPath = "/user/%s/fullname".formatted(nonExistentUserId);
        final var responseEntity = this.testRestTemplate.getForEntity(hostUrl + endpointPath, String.class);

        then(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
