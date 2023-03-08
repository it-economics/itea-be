package com.ite.itea.domain;

import com.ite.itea.domain.dto.ItemDto;
import com.ite.itea.domain.dto.OrderDto;
import com.ite.itea.domain.dto.PicturesDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

class CheckoutCalculatorTest {

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithPictures() {
        CheckoutCalculator checkoutCalculator = new CheckoutCalculator();
        var orderedPicture = new PicturesDto(2);
        OrderDto orderDto = new OrderDto(List.of(orderedPicture));

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.price()).isEqualTo(29.98);
        then(receipt.text()).isEqualTo("itea \nPicture 14.99 * 2\nTotal 29.98");
    }

    @Test
    void shouldReturnCorrectReceiptWhenCalculatingThePriceForAnOrderWithoutItems() {
        CheckoutCalculator checkoutCalculator = new CheckoutCalculator();
        List<ItemDto> nothingOrdered = new ArrayList<>();
        OrderDto orderDto = new OrderDto(nothingOrdered);

        var receipt = checkoutCalculator.calculatePrice(orderDto);

        then(receipt.price()).isEqualTo(0.0);
        then(receipt.text()).isEqualTo("itea \nTotal 0.0");
    }

}