package com.ite.itea.ecommerce.usecase;

import com.ite.itea.ecommerce.domain.retail.Order;
import com.ite.itea.ecommerce.domain.retail.ProductId;
import com.ite.itea.ecommerce.usecase.port.ProductRepository;
import com.ite.itea.ecommerce.usecase.port.ReceiptPresenter;
import com.ite.itea.ecommerce.usecase.dto.OrderRequest;
import com.ite.itea.ecommerce.usecase.dto.Receipt;

import java.util.ArrayList;
import java.util.List;

public class OrderProductsUseCase {

    private final ProductRepository productRepository;
    private final ReceiptPresenter receiptPresenter;

    public OrderProductsUseCase(ProductRepository productRepository, ReceiptPresenter receiptPresenter) {
        this.productRepository = productRepository;
        this.receiptPresenter = receiptPresenter;
    }

    public Receipt execute(OrderRequest orderRequest) {
        final List<Order.OrderItem> orderItems = new ArrayList<>();

        for (var itemRequest : orderRequest.itemRequests()) {
            var productId = new ProductId(itemRequest.name().name());
            var product = productRepository.byId(productId);
            product.ifPresent(value ->
                    orderItems.add(new Order.OrderItem(value, itemRequest.amount())));
        }

        return receiptPresenter.prepareReceipt(new Order(orderItems));
    }
}
