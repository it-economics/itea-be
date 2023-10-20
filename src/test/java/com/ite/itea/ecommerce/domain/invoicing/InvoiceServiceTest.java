package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoiceServiceTest {

    @Test
    void calculatesGrossPriceCorrectly() {
        var invoice = new Invoice(VatPercentage.of(19));
        var twoDiningTables = new LineItem(
                "Some dining table or whatever",
                EuroPrice.ofEurosAndCents(129, 99),
                Quantity.of(2)
        );
        invoice.addLineItems(twoDiningTables);
        var eightDiningChairs = new LineItem(
                "Some dining chair or whatever",
                EuroPrice.ofEurosAndCents(49, 99),
                Quantity.of(8)
        );
        invoice.addLineItems(eightDiningChairs);

        var invoiceService = new InvoiceService();
        var grossPrice = invoice.calculateGrossPrice();

        // The total gross price, with VAT included by default.
        assertThat(grossPrice).isEqualTo(EuroPrice.ofEurosAndCents(659, 90));
    }

    @Test
    void calculatesNetPriceCorrectly() {
        var invoice = new Invoice(VatPercentage.of(19));
        var twoDiningTables = new LineItem(
                "Some dining table or whatever",
                EuroPrice.ofEurosAndCents(129, 99),
                Quantity.of(2)
        );
        invoice.addLineItems(twoDiningTables);
        var eightDiningChairs = new LineItem(
                "Some dining chair or whatever",
                EuroPrice.ofEurosAndCents(49, 99),
                Quantity.of(8)
        );
        invoice.addLineItems(eightDiningChairs);

        var invoiceService = new InvoiceService();
        var netPrice = invoiceService.calculateNetPrice(invoice);

        // The total price excluding 19 % VAT, rounded to the nearest cent.
        assertThat(netPrice).isEqualTo(EuroPrice.ofEurosAndCents(554, 54));
    }
}
