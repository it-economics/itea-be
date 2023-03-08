package com.ite.itea.domain;

import com.ite.itea.domain.dto.ItemDto;
import com.ite.itea.domain.dto.OrderDto;
import com.ite.itea.domain.dto.ReceiptDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Service
public class CheckoutCalculator {

    public ReceiptDto calculatePrice(OrderDto orderDto) {
        var price = getPrice(orderDto);
        var text = getText(orderDto, price);

        return new ReceiptDto(price, text);
    }

    private String getText(OrderDto orderDto, long priceInCents) {
        var text = "itea \n";

        for (ItemDto itemDto : orderDto.itemDtos()) {
            text += convertToText(itemDto);
        }

        text += "Total " + formatPrice(priceInCents);

        return text;
    }

    private String convertToText(ItemDto itemDto) {
        if (itemDto.getAmount() > 0) {
            return MessageFormat.format("{0} {1} * {2}\n", itemDto.getName(), formatPrice(itemDto.getPriceInCents()), itemDto.getAmount());
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

        for (ItemDto itemDto : orderDto.itemDtos()) {
            priceInCents += itemDto.getPriceInCents() * itemDto.getAmount();
        }

        return priceInCents;
    }
}
