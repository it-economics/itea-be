package com.ite.itea.domain;

import com.ite.itea.domain.dto.ItemDto;
import com.ite.itea.domain.dto.OrderDto;
import com.ite.itea.domain.dto.PicturesDto;
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

        var amountOfPictures = 0;

        for (ItemDto itemDto : orderDto.itemDtos()) {
            if (itemDto instanceof PicturesDto) {
                amountOfPictures += itemDto.getAmount();
            }
        }

        if (amountOfPictures > 0) {
            text += MessageFormat.format("Picture 14,99\u00A0€ * {0}\n", amountOfPictures);
        }

        text += "Total " + formatPrice(priceInCents);

        return text;
    }

    private String formatPrice(long priceInCents) {
        var currencyFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        var decimalPrice = BigDecimal.valueOf(priceInCents).movePointLeft(2);
        return currencyFormat.format(decimalPrice);
    }

    private long getPrice(OrderDto orderDto) {
        var priceInCents = 0L;

        for (ItemDto itemDto : orderDto.itemDtos()) {
            if (itemDto instanceof PicturesDto) {
                priceInCents += 1499L * itemDto.getAmount();
            }
        }

        return priceInCents;
    }
}
