package com.ite.itea.presentation;

import com.ite.itea.domain.retail.ProductName;
import com.ite.itea.application.dto.ItemRequest;
import com.ite.itea.application.dto.OrderRequest;
import com.ite.itea.application.dto.ReceiptResponse;
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
        var orderPictureNorway = createItem(ProductName.PictureNorway, 2,999);
        var orderRequest = createOrder(orderPictureNorway);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(1998L);
        then(entity.getBody().text()).isEqualTo("itea \nPictureNorway 9,99\u00A0€ * 2\nTotal 19,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureSwedenToTheController() {
        var orderPictureSweden = createItem(ProductName.PictureSweden, 2, 1299);
        var orderRequest = createOrder(orderPictureSweden);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2598L);
        then(entity.getBody().text()).isEqualTo("itea \nPictureSweden 12,99\u00A0€ * 2\nTotal 25,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAPictureFinlandToTheController() {
        var orderPictureFinland = createItem(ProductName.PictureFinland, 2, 1499);
        var orderRequest = createOrder(orderPictureFinland);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2998L);
        then(entity.getBody().text()).isEqualTo("itea \nPictureFinland 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairElsaToTheController() {
        var orderChairElsa = createItem(ProductName.ChairElsa, 2, 3000);
        var orderRequest = createOrder(orderChairElsa);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(6000L);
        then(entity.getBody().text()).isEqualTo("itea \nChairElsa 30,00\u00A0€ * 2\nTotal 60,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairKnutToTheController() {
        var orderChairKnut = createItem(ProductName.ChairKnut, 2, 4100);
        var orderRequest = createOrder(orderChairKnut);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(8200L);
        then(entity.getBody().text()).isEqualTo("itea \nChairKnut 41,00\u00A0€ * 2\nTotal 82,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairLarsToTheController() {
        var orderChairLars = createItem(ProductName.ChairLars, 2, 5800);
        var orderRequest = createOrder(orderChairLars);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(11600L);
        then(entity.getBody().text()).isEqualTo("itea \nChairLars 58,00\u00A0€ * 2\nTotal 116,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithATableLottaToTheController() {
        var orderTableLotta = createItem(ProductName.TableLotta, 2, 500);
        var orderRequest = createOrder(orderTableLotta);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(10000L);
        then(entity.getBody().text()).isEqualTo("itea \nTableLotta 50,00\u00A0€ * 2\nTotal 100,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithATableLolaToTheController() {
        var orderTableLola = createItem(ProductName.TableLola, 2, 1300);
        var orderRequest = createOrder(orderTableLola);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(26000L);
        then(entity.getBody().text()).isEqualTo("itea \nTableLola 130,00\u00A0€ * 2\nTotal 260,00\u00A0€");
    }

    @Test
    void shouldReturn200WhenSendingRequestToManagementEndpoint() {
        var entity = this.testRestTemplate.getForEntity("http://localhost:" + this.actuatorPort + "/actuator", Map.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private OrderRequest createOrder(ItemRequest item) {
        return new OrderRequest(List.of(item));
    }

    private ItemRequest createItem(ProductName name, int amount, long price) {
        return new ItemRequest(name, amount, price);
    }
}
