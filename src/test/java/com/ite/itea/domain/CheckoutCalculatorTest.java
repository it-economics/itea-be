package com.ite.itea.domain;

import com.ite.itea.application.dto.*;
import com.ite.itea.domain.retail.ProductName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class CheckoutCalculatorTest {

    private final CheckoutCalculator checkoutCalculator = new CheckoutCalculator();

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictureNorway() {
        var orderedPicturesNorway = new PicturesDTO(ProductName.PictureNorway, 2, 999L);
        var orderDto = createOrder(orderedPicturesNorway);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(1998L);
        then(receipt.text()).isEqualTo("itea \nPictureNorway 9,99\u00A0€ * 2\nTotal 19,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictureSweden() {
        var orderedPicturesSweden = new PicturesDTO(ProductName.PictureSweden,2, 1299L);
        var orderDto = createOrder(orderedPicturesSweden);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(2598L);
        then(receipt.text()).isEqualTo("itea \nPictureSweden 12,99\u00A0€ * 2\nTotal 25,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictureFinland() {
        var orderedPicturesFinland = new PicturesDTO(ProductName.PictureFinland,2, 1499L);
        var orderDto = createOrder(orderedPicturesFinland);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(2998L);
        then(receipt.text()).isEqualTo("itea \nPictureFinland 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairElsa() {
        var orderedChairElsa = new ChairsDTO(ProductName.ChairElsa, 2, 500, 500, 500, "plastic");
        var orderDto = createOrder(orderedChairElsa);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(6000L);
        then(receipt.text()).isEqualTo("itea \nChairElsa 30,00\u00A0€ * 2\nTotal 60,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairKnut() {
        var orderedChairKnut = new ChairsDTO(ProductName.ChairKnut, 2, 400, 1000, 1500,  "wood");
        var orderDto = createOrder(orderedChairKnut);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(8200L);
        then(receipt.text()).isEqualTo("itea \nChairKnut 41,00\u00A0€ * 2\nTotal 82,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairLars() {
        var orderedChairLars = new ChairsDTO(ProductName.ChairLars, 2, 200, 2000, 3000, "metal");
        var orderDto = createOrder(orderedChairLars);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(11600L);
        then(receipt.text()).isEqualTo("itea \nChairLars 58,00\u00A0€ * 2\nTotal 116,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithTableLotta() {
        var orderedTablesLotta = new TablesDTO(ProductName.TableLotta, 2, 1000, 3000, "plastic");
        var orderDto = createOrder(orderedTablesLotta);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(14000L);
        then(receipt.text()).isEqualTo("itea \nTableLotta 70,00\u00A0€ * 2\nTotal 140,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithTableLola() {
        var orderedTablesLola = new TablesDTO(ProductName.TableLola, 2, 2000, 5000, "wood");
        var orderDto = createOrder(orderedTablesLola);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(26000L);
        then(receipt.text()).isEqualTo("itea \nTableLola 130,00\u00A0€ * 2\nTotal 260,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithoutItems() {
        List<ProductDTO> nothingOrdered = new ArrayList<>();
        var orderDto = new OrderDTO(nothingOrdered);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(0L);
        then(receipt.text()).isEqualTo("itea \nTotal 0,00\u00A0€");
    }

    private OrderDTO createOrder(ProductDTO orderedItem) {
        return new OrderDTO(List.of(orderedItem));
    }

}
