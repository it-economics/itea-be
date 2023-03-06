package com.ite.itea.domain;

import com.ite.itea.domain.dto.ItemDto;
import com.ite.itea.domain.dto.OrderDto;
import com.ite.itea.domain.dto.PictureDto;
import org.springframework.stereotype.Service;

@Service
public class CheckoutCalculator {

    public Receipt calculatePrice(OrderDto orderDto) {
        var price = getPrice(orderDto);
        var text = getText(orderDto, price);

        return new Receipt(price, text);
    }

    private String getText(OrderDto orderDto, double price) {
        var text = "itea \n";

        var amountOfPictures = 0;

        for (ItemDto itemDto : orderDto.itemDtos()) {
            if (itemDto instanceof PictureDto) {
                amountOfPictures += itemDto.getAmount();
            }
        }

        if (amountOfPictures > 0) {
            text += "Picture " + 14.99 + " * " + amountOfPictures + "\n";
        }

        text += "Total " + price;

        return text;
    }

    private double getPrice(OrderDto orderDto) {
        var price = 0.0;

        for (ItemDto itemDto : orderDto.itemDtos()) {
            if (itemDto instanceof PictureDto) {
                price += 14.99 * itemDto.getAmount();
            }
        }

        return price;
    }
}
