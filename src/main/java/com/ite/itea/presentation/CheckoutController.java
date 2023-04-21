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
        List<OrderPointDto> itemDtoList = new ArrayList<>();

        for (ItemRequest itemRequest : orderRequest.itemRequests()) {
            switch (itemRequest.name()) {
                case Picture -> itemDtoList.add(new OrderPointDto(itemRequest.amount(), new PicturesDto(itemRequest.amount()));
                case Chair -> itemDtoList.add(new OrderPointDto(itemRequest.amount(), getDefaultChair()));
                case ChairLars -> itemDtoList.add(new OrderPointDto(itemRequest.amount(),new ChairLars()));
                case ChairKnut -> itemDtoList.add(new OrderPointDto(itemRequest.amount(),new ChairKnut()));
                case ChairElsa -> itemDtoList.add(new ChairElsa(itemRequest.amount()));
                case TableLotta -> itemDtoList.add(new TableLotta(itemRequest.amount()));
                case TableLola -> itemDtoList.add(new TableLola(itemRequest.amount()));
            }
        }

        ReceiptDto receiptDto = checkoutCalculator.calculatePrice(new OrderDto(itemDtoList));

        return new ReceiptResponse(receiptDto.priceInCents(), receiptDto.text());
    }

    private static ChairsDto getDefaultChair() {
        return new ChairsDto( 2000, 4000, 2999, 4, Material.WOOD);
    }

}
