package com.ite.itea.ecommerce.integration.in.controller;

import com.ite.itea.ecommerce.usecase.dto.Room;
import com.ite.itea.ecommerce.usecase.dto.Wall;
import com.ite.itea.ecommerce.usecase.dto.WallPaintAmountRequest;
import com.ite.itea.ecommerce.usecase.dto.WallPaintAmountResponse;
import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = {"management.port=0"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoomPlannerControllerTest {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int actuatorPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @ParameterizedTest
    @CsvSource(value = {
            "f9a4905d-df31-4439-bac7-96528baf5a5a,4.8,2.44,81.98",
            "c9cf727e-f676-4d9c-b771-2df6a5e8fc51,13.37,3.14,419.81"
    })
    void determinesRequiredAmountOfWallPaintForGivenRoomAndPaint(
            String wallPaintId, float roomWidth, float roomHeight, float expectedRequiredAmount
    ) {
        var wallPaintAmountRequest = new WallPaintAmountRequest(
                new Room(List.of(new Wall(roomWidth, roomHeight))),
                wallPaintId
        );

        var entity = this.testRestTemplate.postForEntity(
                "http://localhost:%d/wallpaint".formatted(this.port),
                wallPaintAmountRequest,
                WallPaintAmountResponse.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().requiredPaintAmountLiters()).isCloseTo(expectedRequiredAmount, Offset.offset(0.01f));
    }
}
