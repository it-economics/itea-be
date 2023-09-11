package com.ite.itea.ecommerce.integration.in.controller;

import com.ite.itea.ecommerce.domain.retail.ProductName;
import com.ite.itea.ecommerce.usecase.dto.ItemRequest;
import com.ite.itea.ecommerce.usecase.dto.OrderRequest;
import com.ite.itea.ecommerce.usecase.dto.ReceiptResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@TestPropertySource(properties = {"management.port=0"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CheckoutControllerTest {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int actuatorPort;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureNorwayToTheController() {
        var orderPictureNorway = new ItemRequest(ProductName.PICTURE_NORWAY, 2);
        var orderRequest = new OrderRequest(List.of(orderPictureNorway));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(1998L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture \"Norway\" 9,99\u00A0€ * 2\nTotal 19,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureSwedenToTheController() {
        var orderPictureSweden = new ItemRequest(ProductName.PICTURE_SWEDEN, 2);
        var orderRequest = new OrderRequest(List.of(orderPictureSweden));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2598L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture \"Sweden\" 12,99\u00A0€ * 2\nTotal 25,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureFinlandToTheController() {
        var orderPictureFinland = new ItemRequest(ProductName.PICTURE_FINLAND, 2);
        var orderRequest = new OrderRequest(List.of(orderPictureFinland));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2998L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture \"Finland\" 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairOlafToTheController() {
        var orderChairOlaf = new ItemRequest(ProductName.CHAIR_OLAF, 2);
        var orderRequest = new OrderRequest(List.of(orderChairOlaf));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(6000L);
        then(entity.getBody().text()).isEqualTo("itea \nChair \"Olaf\" 30,00\u00A0€ * 2\nTotal 60,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairKnutToTheController() {
        var orderChairKnut = new ItemRequest(ProductName.CHAIR_KNUT, 2);
        var orderRequest = new OrderRequest(List.of(orderChairKnut));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(8200L);
        then(entity.getBody().text()).isEqualTo("itea \nChair \"Knut\" 41,00\u00A0€ * 2\nTotal 82,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairLarsToTheController() {
        var orderChairLars = new ItemRequest(ProductName.CHAIR_LARS, 2);
        var orderRequest = new OrderRequest(List.of(orderChairLars));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(11600L);
        then(entity.getBody().text()).isEqualTo("itea \nChair \"Lars\" 58,00\u00A0€ * 2\nTotal 116,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithATableLottaToTheController() {
        var orderTableLotta = new ItemRequest(ProductName.TABLE_LOTTA, 2);
        var orderRequest = new OrderRequest(List.of(orderTableLotta));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(10000L);
        then(entity.getBody().text()).isEqualTo("itea \nTable \"Lotta\" 50,00\u00A0€ * 2\nTotal 100,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithATableLolaToTheController() {
        var orderTableLola = new ItemRequest(ProductName.TABLE_LOLA, 2);
        var orderRequest = new OrderRequest(List.of(orderTableLola));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(26000L);
        then(entity.getBody().text()).isEqualTo("itea \nTable \"Lola\" 130,00\u00A0€ * 2\nTotal 260,00\u00A0€");
    }

    @Test
    void shouldReturn200WhenSendingRequestToManagementEndpoint() {
        var entity = this.testRestTemplate.getForEntity("http://localhost:" + this.actuatorPort + "/actuator", Map.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
