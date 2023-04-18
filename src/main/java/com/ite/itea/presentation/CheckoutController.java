package com.ite.itea.presentation;

import com.ite.itea.domain.CheckoutCalculator;
import com.ite.itea.domain.dto.*;
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
            if (ItemNameRequest.PictureNorway.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.name(), itemRequest.amount(), 999L);
                itemDtoList.add(itemDto);
            } else if (ItemNameRequest.PictureSweden.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.name(), itemRequest.amount(), 1299L);
                itemDtoList.add(itemDto);
            } else if (ItemNameRequest.PictureFinland.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.name(), itemRequest.amount(), 1499L);
                itemDtoList.add(itemDto);
            } else if (ItemNameRequest.ChairElsa.equals(itemRequest.name())) {
                ItemDto itemDto = new ChairsDto(itemRequest.name(), itemRequest.amount(), 500, 500, 500, "plastic");
                itemDtoList.add(itemDto);
            } else if (ItemNameRequest.ChairKnut.equals(itemRequest.name())) {
                ItemDto itemDto = new ChairsDto(itemRequest.name(), itemRequest.amount(), 400, 1000, 1500,  "wood");
                itemDtoList.add(itemDto);
            } else if (ItemNameRequest.ChairLars.equals(itemRequest.name())) {
                ItemDto itemDto = new ChairsDto(itemRequest.name(), itemRequest.amount(), 200, 2000, 3000, "metal");
                itemDtoList.add(itemDto);
            } else if (ItemNameRequest.TableLotta.equals(itemRequest.name())) {
                ItemDto itemDto = new TablesDto(itemRequest.name(), itemRequest.amount(), 1000, 1000, "plastic");
                itemDtoList.add(itemDto);
            }else if (ItemNameRequest.TableLola.equals(itemRequest.name())) {
                ItemDto itemDto = new TablesDto(itemRequest.name(), itemRequest.amount(), 3000, 1000, "plastic");
                itemDtoList.add(itemDto);
            }
        }

        ReceiptDto receiptDto = checkoutCalculator.calculatePrice(new OrderDto(itemDtoList));

        return new ReceiptResponse(receiptDto.priceInCents(), receiptDto.text());
    }

}
