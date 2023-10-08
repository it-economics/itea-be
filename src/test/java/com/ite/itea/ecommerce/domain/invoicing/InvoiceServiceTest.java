package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceServiceTest {

    @Test
    void calculatesGrossPriceCorrectly() {
        var invoice = new Invoice();
        var twoDiningTables = new LineItem(
                "Some dining table or whatever",
                EuroPrice.ofEurosAndCents(129, 99),
                Quantity.of(2)
        );
        invoice.getLineItems().add(twoDiningTables);
        var eightDiningChairs = new LineItem(
                "Some dining chair or whatever",
                EuroPrice.ofEurosAndCents(49, 99),
                Quantity.of(8)
        );
        invoice.getLineItems().add(eightDiningChairs);

        var invoiceService = new InvoiceService();
        var grossPrice = invoiceService.calculateGrossPrice(invoice);

        assertThat(grossPrice).isEqualTo(EuroPrice.ofEurosAndCents(659, 90));
    }
}
