package com.ite.itea.presentation;

import com.ite.itea.domain.request.ItemNameRequest;
import com.ite.itea.domain.request.ItemRequest;
import com.ite.itea.domain.request.OrderRequest;
import com.ite.itea.domain.response.ReceiptResponse;
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
    void shouldReturnCorrectReceiptWhenSendingRequestToController() {
        var orderPicture = createItem(ItemNameRequest.Picture, 2);
        var orderRequest = createOrder(orderPicture);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(2998L);
        then(entity.getBody().text()).isEqualTo("itea \nPicture 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenSendingRequestWithAChairToTheController() {
        var orderChair = createItem(ItemNameRequest.Chair, 2);
        var orderRequest = createOrder(orderChair);

        var entity = this.testRestTemplate.postForEntity("http://localhost:" + this.port + "/checkout", orderRequest, ReceiptResponse.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(entity.getBody().priceInCents()).isEqualTo(29998L);
        then(entity.getBody().text()).isEqualTo("itea \nChair 149,99\u00A0€ * 2\nTotal 299,98\u00A0€");
    }

    @Test
    void shouldReturn200WhenSendingRequestToManagementEndpoint() {
        var entity = this.testRestTemplate.getForEntity("http://localhost:" + this.actuatorPort + "/actuator", Map.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private OrderRequest createOrder(ItemRequest item) {
        return new OrderRequest(List.of(item));
    }

    private ItemRequest createItem(ItemNameRequest name, int amount) {
        return new ItemRequest(name, amount);
    }
}
