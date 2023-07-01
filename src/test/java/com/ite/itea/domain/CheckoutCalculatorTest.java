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
        var orderedPicturesNorway = new PicturesDTO(ProductName.PICTURE_NORWAY, 2, 999L);
        var orderDto = new OrderDTO(List.of(orderedPicturesNorway));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(1998L);
        then(receipt.text()).isEqualTo("itea \nPicture \"Norway\" 9,99\u00A0€ * 2\nTotal 19,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictureSweden() {
        var orderedPicturesSweden = new PicturesDTO(ProductName.PICTURE_SWEDEN,2, 1299L);
        var orderDto = new OrderDTO(List.of(orderedPicturesSweden));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(2598L);
        then(receipt.text()).isEqualTo("itea \nPicture \"Sweden\" 12,99\u00A0€ * 2\nTotal 25,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictureFinland() {
        var orderedPicturesFinland = new PicturesDTO(ProductName.PICTURE_FINLAND,2, 1499L);
        var orderDto = new OrderDTO(List.of(orderedPicturesFinland));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(2998L);
        then(receipt.text()).isEqualTo("itea \nPicture \"Finland\" 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairElsa() {
        var orderedChairElsa = new ChairsDTO(ProductName.CHAIR_ELSA, 2, 500, 500, 500, "plastic");
        var orderDto = new OrderDTO(List.of(orderedChairElsa));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(6000L);
        then(receipt.text()).isEqualTo("itea \nChair \"Elsa\" 30,00\u00A0€ * 2\nTotal 60,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairKnut() {
        var orderedChairKnut = new ChairsDTO(ProductName.CHAIR_KNUT, 2, 400, 1000, 1500,  "wood");
        var orderDto = new OrderDTO(List.of(orderedChairKnut));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(8200L);
        then(receipt.text()).isEqualTo("itea \nChair \"Knut\" 41,00\u00A0€ * 2\nTotal 82,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairLars() {
        var orderedChairLars = new ChairsDTO(ProductName.CHAIR_LARS, 2, 200, 2000, 3000, "metal");
        var orderDto = new OrderDTO(List.of(orderedChairLars));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(11600L);
        then(receipt.text()).isEqualTo("itea \nChair \"Lars\" 58,00\u00A0€ * 2\nTotal 116,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithTableLotta() {
        var orderedTablesLotta = new TablesDTO(ProductName.TABLE_LOTTA, 2, 1000, 3000, "plastic");
        var orderDto = new OrderDTO(List.of(orderedTablesLotta));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(14000L);
        then(receipt.text()).isEqualTo("itea \nTable \"Lotta\" 70,00\u00A0€ * 2\nTotal 140,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithTableLola() {
        var orderedTablesLola = new TablesDTO(ProductName.TABLE_LOLA, 2, 2000, 5000, "wood");
        var orderDto = new OrderDTO(List.of(orderedTablesLola));

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(26000L);
        then(receipt.text()).isEqualTo("itea \nTable \"Lola\" 130,00\u00A0€ * 2\nTotal 260,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithoutItems() {
        List<ProductDTO> nothingOrdered = new ArrayList<>();
        var orderDto = new OrderDTO(nothingOrdered);

        var receipt = checkoutCalculator.prepareReceipt(orderDto);

        then(receipt.priceInCents()).isEqualTo(0L);
        then(receipt.text()).isEqualTo("itea \nTotal 0,00\u00A0€");
    }
}
