package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.OrderDTO;
import com.ite.itea.application.dto.ReceiptDTO;
import com.ite.itea.domain.CheckoutCalculator;

public class CalculateTotalPriceUseCase {

    private final CheckoutCalculator checkoutCalculator = new CheckoutCalculator();

    public ReceiptDTO execute(OrderDTO order) {
        return checkoutCalculator.calculatePrice(order);
    }
}
