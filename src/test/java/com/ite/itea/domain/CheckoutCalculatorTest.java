package com.ite.itea.domain;

import com.ite.itea.domain.dto.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class CheckoutCalculatorTest {

    private final CheckoutCalculator checkoutCalculator = new CheckoutCalculator();

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictures() {
        var orderedPicture = new PicturesDto(2);
        var orderDto = createOrder(orderedPicture);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(2998L);
        then(receipt.text()).isEqualTo("itea \nPicture 14,99\u00A0€ * 2\nTotal 29,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithChairs() {
        var orderedChairs = new ChairsDto(2, 2000, 4000, 2999, 4, Material.WOOD);
        var orderDto = createOrder(orderedChairs);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(29998L);
        then(receipt.text()).isEqualTo("itea \nChair 149,99\u00A0€ * 2\nTotal 299,98\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithTables() {
        var orderedTables = new TablesDto(2, 1000, 3000, Material.WOOD);
        var orderDto = createOrder(orderedTables);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(14000L);
        then(receipt.text()).isEqualTo("itea \nTable 70,00\u00A0€ * 2\nTotal 140,00\u00A0€");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithoutItems() {
        List<ItemDto> nothingOrdered = new ArrayList<>();
        var orderDto = new OrderDto(nothingOrdered);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.priceInCents()).isEqualTo(0L);
        then(receipt.text()).isEqualTo("itea \nTotal 0,00\u00A0€");
    }

    private OrderDto createOrder(ItemDto orderedItem) {
        return new OrderDto(List.of(orderedItem));
    }

}
