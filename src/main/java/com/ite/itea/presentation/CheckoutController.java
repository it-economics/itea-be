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
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (ItemRequest itemRequest : orderRequest.itemRequests()) {
            if (ProductName.PictureNorway.equals(itemRequest.name())) {
                ProductDTO productDTO = new PicturesDto(itemRequest.name(), itemRequest.amount(), 999L);
                productDTOList.add(productDTO);
            } else if (ProductName.PictureSweden.equals(itemRequest.name())) {
                ProductDTO productDTO = new PicturesDto(itemRequest.name(), itemRequest.amount(), 1299L);
                productDTOList.add(productDTO);
            } else if (ProductName.PictureFinland.equals(itemRequest.name())) {
                ProductDTO productDTO = new PicturesDto(itemRequest.name(), itemRequest.amount(), 1499L);
                productDTOList.add(productDTO);
            } else if (ProductName.ChairElsa.equals(itemRequest.name())) {
                ProductDTO productDTO = new ChairsDto(itemRequest.name(), itemRequest.amount(), 500, 500, 500, "plastic");
                productDTOList.add(productDTO);
            } else if (ProductName.ChairKnut.equals(itemRequest.name())) {
                ProductDTO productDTO = new ChairsDto(itemRequest.name(), itemRequest.amount(), 400, 1000, 1500,  "wood");
                productDTOList.add(productDTO);
            } else if (ProductName.ChairLars.equals(itemRequest.name())) {
                ProductDTO productDTO = new ChairsDto(itemRequest.name(), itemRequest.amount(), 200, 2000, 3000, "metal");
                productDTOList.add(productDTO);
            } else if (ProductName.TableLotta.equals(itemRequest.name())) {
                ProductDTO productDTO = new TablesDto(itemRequest.name(), itemRequest.amount(), 1000, 1000, "plastic");
                productDTOList.add(productDTO);
            }else if (ProductName.TableLola.equals(itemRequest.name())) {
                ProductDTO productDTO = new TablesDto(itemRequest.name(), itemRequest.amount(), 3000, 1000, "plastic");
                productDTOList.add(productDTO);
            }
        }

        ReceiptDto receiptDto = calculateTotalPriceUseCase.execute(new OrderDto(productDTOList));

        return new ReceiptResponse(receiptDto.priceInCents(), receiptDto.text());
    }
}
