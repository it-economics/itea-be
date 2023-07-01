package com.ite.itea.application.usecase;

import com.ite.itea.application.dto.OrderRequest;
import com.ite.itea.application.dto.ReceiptDTO;
import com.ite.itea.domain.CheckoutCalculator;
import com.ite.itea.domain.retail.Order;
import com.ite.itea.domain.retail.ProductId;
import com.ite.itea.domain.retail.ProductRepository;
import com.ite.itea.persistence.InMemoryProductRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderProductsUseCase {

    private final ProductRepository productRepository = new InMemoryProductRepository();
    private final CheckoutCalculator checkoutCalculator = new CheckoutCalculator();

    public ReceiptDTO execute(OrderRequest orderRequest) {
        final List<Order.OrderItem> orderItems = new ArrayList<>();

        for (var itemRequest : orderRequest.itemRequests()) {
            var productId = new ProductId(itemRequest.name().name());
            var product = productRepository.byId(productId);
            product.ifPresent(value ->
                    orderItems.add(new Order.OrderItem(value, itemRequest.amount())));
        }

        return checkoutCalculator.prepareReceipt(new Order(orderItems));
    }
}
