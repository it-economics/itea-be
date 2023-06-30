package com.ite.itea.presentation;

import com.ite.itea.application.dto.*;
import com.ite.itea.application.usecase.CalculateTotalPriceUseCase;
import com.ite.itea.domain.retail.ProductName;
import com.ite.itea.presentation.request.ItemRequest;
import com.ite.itea.presentation.request.OrderRequest;
import com.ite.itea.presentation.response.ReceiptResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CheckoutController {

    private final CalculateTotalPriceUseCase calculateTotalPriceUseCase = new CalculateTotalPriceUseCase();

    @ResponseBody
    @PostMapping(path = "/checkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptResponse calculate(@RequestBody OrderRequest orderRequest) {
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (ItemRequest itemRequest : orderRequest.itemRequests()) {
            if (ProductName.PictureNorway.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.name(), itemRequest.amount(), 999L);
                itemDtoList.add(itemDto);
            } else if (ProductName.PictureSweden.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.name(), itemRequest.amount(), 1299L);
                itemDtoList.add(itemDto);
            } else if (ProductName.PictureFinland.equals(itemRequest.name())) {
                ItemDto itemDto = new PicturesDto(itemRequest.name(), itemRequest.amount(), 1499L);
                itemDtoList.add(itemDto);
            } else if (ProductName.ChairElsa.equals(itemRequest.name())) {
                ItemDto itemDto = new ChairsDto(itemRequest.name(), itemRequest.amount(), 500, 500, 500, "plastic");
                itemDtoList.add(itemDto);
            } else if (ProductName.ChairKnut.equals(itemRequest.name())) {
                ItemDto itemDto = new ChairsDto(itemRequest.name(), itemRequest.amount(), 400, 1000, 1500,  "wood");
                itemDtoList.add(itemDto);
            } else if (ProductName.ChairLars.equals(itemRequest.name())) {
                ItemDto itemDto = new ChairsDto(itemRequest.name(), itemRequest.amount(), 200, 2000, 3000, "metal");
                itemDtoList.add(itemDto);
            } else if (ProductName.TableLotta.equals(itemRequest.name())) {
                ItemDto itemDto = new TablesDto(itemRequest.name(), itemRequest.amount(), 1000, 1000, "plastic");
                itemDtoList.add(itemDto);
            }else if (ProductName.TableLola.equals(itemRequest.name())) {
                ItemDto itemDto = new TablesDto(itemRequest.name(), itemRequest.amount(), 3000, 1000, "plastic");
                itemDtoList.add(itemDto);
            }
        }

        ReceiptDto receiptDto = calculateTotalPriceUseCase.execute(new OrderDto(itemDtoList));

        return new ReceiptResponse(receiptDto.priceInCents(), receiptDto.text());
    }
}
