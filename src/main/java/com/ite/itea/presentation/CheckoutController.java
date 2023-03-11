package com.ite.itea.presentation;

import com.ite.itea.domain.CheckoutCalculator;
import com.ite.itea.domain.dto.ItemDto;
import com.ite.itea.domain.dto.OrderDto;
import com.ite.itea.domain.dto.PicturesDto;
import com.ite.itea.domain.dto.ReceiptDto;
import com.ite.itea.domain.request.ItemNameRequest;
import com.ite.itea.domain.request.ItemRequest;
import com.ite.itea.domain.request.OrderRequest;
import com.ite.itea.domain.response.ReceiptResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckoutController {

    private final CheckoutCalculator checkoutCalculator;

    public CheckoutController(CheckoutCalculator checkoutCalculator) {
        this.checkoutCalculator = checkoutCalculator;
    }

    @ResponseBody
    @PostMapping(path = "/checkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptResponse calculate(@RequestBody OrderRequest orderRequest) {
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (ItemRequest itemRequest : orderRequest.itemRequests()) {
            if (ItemNameRequest.Picture.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.amount());
                itemDtoList.add(itemDto);
            }
        }

        ReceiptDto receiptDto = checkoutCalculator.calculatePrice(new OrderDto(itemDtoList));

        return new ReceiptResponse(receiptDto.priceInCents(), receiptDto.text());
    }

}
