package com.ite.itea.ecommerce.integration.in.controller;

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
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureOsloToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("2", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(1998L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture \"Oslo\" 9,99\u00A0€ * 2\nTotal 19,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureSwedenToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("3", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2598L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture \"Sweden\" 12,99\u00A0€ * 2\nTotal 25,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureFinlandToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("1", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2998L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture \"Finland\" 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairOlafToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("6", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(6000L);
        then(entity.getBody().text()).isEqualTo("itea \nChair \"Olaf\" 30,00\u00A0€ * 2\nTotal 60,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairKnutToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("7", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(8200L);
        then(entity.getBody().text()).isEqualTo("itea \nChair \"Knut\" 41,00\u00A0€ * 2\nTotal 82,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairLarsToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("8", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(11600L);
        then(entity.getBody().text()).isEqualTo("itea \nChair \"Lars\" 58,00\u00A0€ * 2\nTotal 116,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithATableLottaToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("5", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(10000L);
        then(entity.getBody().text()).isEqualTo("itea \nTable \"Lotta\" 50,00\u00A0€ * 2\nTotal 100,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithATableLolaToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("4", 2)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(26000L);
        then(entity.getBody().text()).isEqualTo("itea \nTable \"Lola\" 130,00\u00A0€ * 2\nTotal 260,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAClosetRagnarokToTheController() {
        var orderRequest = new OrderRequest(List.of(new ItemRequest("10", 4)));

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(131996);
        then(entity.getBody().text()).isEqualTo("itea \nCloset \"Ragnarök\" 329,99\u00A0€ * 4\nTotal 1.319,96\u00A0€");
    }

    @Test
    void shouldReturn200WhenSendingRequestToManagementEndpoint() {
        var entity = this.testRestTemplate.getForEntity("http://localhost:" + this.actuatorPort + "/actuator", Map.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
