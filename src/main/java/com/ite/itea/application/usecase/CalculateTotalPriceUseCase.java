package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.OrderDto;
import com.ite.itea.application.dto.ReceiptDto;
import com.ite.itea.domain.CheckoutCalculator;

public class CalculateTotalPriceUseCase {

    private final CheckoutCalculator checkoutCalculator = new CheckoutCalculator();

    public ReceiptDto execute(OrderDto order) {
        return checkoutCalculator.calculatePrice(order);
    }
}
