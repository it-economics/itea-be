package com.ite.itea.ecommerce.integration.in.controller;

import com.ite.itea.ecommerce.usecase.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

@TestPropertySource(properties = {"management.port=0"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoomPlannerControllerTest {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int actuatorPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void determinesRequiredAmountOfWallPaintForGivenRoomAndPaint() {
        var wallPaintAmountRequest = new WallPaintAmountRequest(
                new Room(List.of(new Wall(4.8f, 2.44f))),
                1L
        );

        var entity = this.testRestTemplate.postForEntity(
                "http://localhost:%d/wallpaint".formatted(this.port),
                wallPaintAmountRequest,
                WallPaintAmountResponse.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().requiredPaintAmountLiters()).isEqualTo(42.3f);
    }
}
