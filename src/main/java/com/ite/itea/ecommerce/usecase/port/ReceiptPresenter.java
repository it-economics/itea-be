package com.ite.itea.ecommerce.usecase.port;

import com.ite.itea.ecommerce.domain.retail.Order;
import com.ite.itea.ecommerce.usecase.dto.Receipt;

public interface ReceiptPresenter {
    Receipt prepareReceipt(Order order);
}
