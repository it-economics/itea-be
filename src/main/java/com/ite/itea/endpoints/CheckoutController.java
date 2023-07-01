package com.ite.itea.endpoints;

import com.ite.itea.application.dto.*;
import com.ite.itea.application.usecase.CalculateTotalPriceUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CheckoutController {

    private final CalculateTotalPriceUseCase calculateTotalPriceUseCase = new CalculateTotalPriceUseCase();

    @ResponseBody
    @PostMapping(path = "/checkout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ReceiptResponse calculate(@RequestBody OrderRequest orderRequest) {
        final List<ProductDTO> productsToOrder = orderRequest.itemRequests().stream()
                .map(itemRequest -> switch (itemRequest.name()) {
                    case PICTURE_FINLAND -> new PicturesDTO(itemRequest.name(), itemRequest.amount(), 1499L);
                    case PICTURE_NORWAY -> new PicturesDTO(itemRequest.name(), itemRequest.amount(), 999L);
                    case PICTURE_SWEDEN -> new PicturesDTO(itemRequest.name(), itemRequest.amount(), 1299L);
                    case CHAIR_ELSA -> new ChairsDTO(itemRequest.name(), itemRequest.amount(), 500, 500, 500, "plastic");
                    case CHAIR_LARS -> new ChairsDTO(itemRequest.name(), itemRequest.amount(), 200, 2000, 3000, "metal");
                    case CHAIR_KNUT -> new ChairsDTO(itemRequest.name(), itemRequest.amount(), 400, 1000, 1500, "wood");
                    case TABLE_LOTTA -> new TablesDTO(itemRequest.name(), itemRequest.amount(), 1000, 1000, "plastic");
                    case TABLE_LOLA -> new TablesDTO(itemRequest.name(), itemRequest.amount(), 3000, 1000, "plastic");
                })
                .collect(Collectors.toList());

        final ReceiptDTO receiptDto = calculateTotalPriceUseCase.execute(new OrderDTO(productsToOrder));

        return new ReceiptResponse(receiptDto.priceInCents(), receiptDto.text());
    }
}
