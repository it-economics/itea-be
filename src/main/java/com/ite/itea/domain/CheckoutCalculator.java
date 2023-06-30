package com.ite.itea.domain;

import com.ite.itea.application.dto.ProductDTO;
import com.ite.itea.application.dto.OrderDto;
import com.ite.itea.application.dto.ReceiptDto;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CheckoutCalculator {

    public ReceiptDto calculatePrice(OrderDto orderDto) {
        var price = getPrice(orderDto);
        var text = getText(orderDto, price);

        return new ReceiptDto(price, text);
    }

    private String getText(OrderDto orderDto, long priceInCents) {
        var text = "itea \n";

        for (ProductDTO productDTO : orderDto.productDTOs()) {
            text += convertToText(productDTO);
        }

        text += "Total " + formatPrice(priceInCents);

        return text;
    }

    private String convertToText(ProductDTO productDTO) {
        if (productDTO.getAmount() > 0) {
            return MessageFormat.format("{0} {1} * {2}\n", productDTO.getName(), formatPrice(productDTO.getPriceInCents()), productDTO.getAmount());
        }
        return "";
    }

    private String formatPrice(long priceInCents) {
        var currencyFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        var decimalPrice = BigDecimal.valueOf(priceInCents).movePointLeft(2);
        return currencyFormat.format(decimalPrice);
    }

    private long getPrice(OrderDto orderDto) {
        var priceInCents = 0L;

        for (ProductDTO productDTO : orderDto.productDTOs()) {
            priceInCents += productDTO.getPriceInCents() * productDTO.getAmount();
        }

        return priceInCents;
    }
}
