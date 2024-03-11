package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvoicePricingTest {

    private final LineItem twoDiningTables = new LineItem(
            "Some dining table or whatever",
            EuroPrice.ofEurosAndCents(129, 99),
            Quantity.of(2),
            VatRate.STANDARD
    );
    private final LineItem eightDiningChairs = new LineItem(
            "Some dining chair or whatever",
            EuroPrice.ofEurosAndCents(49, 99),
            Quantity.of(8),
            VatRate.STANDARD
    );
    private final LineItem threeStoreRestaurantMenus = new LineItem(
            "Store Restaurant Menu: 2 hot dogs and a soda",
            EuroPrice.ofEurosAndCents(12, 79),
            Quantity.of(3),
            VatRate.REDUCED
    );

    @Test
    void calculatesCorrectGrossPriceWithStandardTaxRate() {
        var invoice = new Invoice();
        invoice.addLineItem(twoDiningTables);
        invoice.addLineItem(eightDiningChairs);

        // The total gross price including VAT.
        assertThat(invoice.grossPrice()).isEqualTo(EuroPrice.ofEurosAndCents(659, 90));
    }

    @Test
    void calculatesCorrectNetPriceWithStandardTaxRate() {
        var invoice = new Invoice();
        invoice.addLineItem(twoDiningTables);
        invoice.addLineItem(eightDiningChairs);

        // The total price excluding 19 % VAT, rounded per item to the nearest cent.
        assertThat(invoice.netPrice()).isEqualTo(EuroPrice.ofEurosAndCents(554, 56));
    }

    @Test
    void calculatesCorrectGrossPriceForVatReducedItems() {
        var invoice = new Invoice();
        invoice.addLineItem(threeStoreRestaurantMenus);

        // The total gross price including VAT.
        assertThat(invoice.grossPrice()).isEqualTo(EuroPrice.ofEurosAndCents(38, 37));
    }

    @Test
    void calculatesCorrectNetPriceForVatReducedItems() {
        var invoice = new Invoice();
        invoice.addLineItem(threeStoreRestaurantMenus);

        // The total price excluding 7 % VAT, i.e., the reduced VAT rate for food and groceries,
        // rounded per item to the nearest cent.
        assertThat(invoice.netPrice()).isEqualTo(EuroPrice.ofEurosAndCents(35, 85));
    }

    @Test
    void calculatesCorrectNetPriceForMixedVatRates() {
        var invoice = new Invoice();
        invoice.addLineItem(threeStoreRestaurantMenus);
        invoice.addLineItem(twoDiningTables);
        invoice.addLineItem(eightDiningChairs);

        // The total price excluding 7 % VAT, i.e., the reduced VAT rate for food and groceries,
        // rounded per item to the nearest cent.
        assertThat(invoice.netPrice()).isEqualTo(EuroPrice.ofEurosAndCents(590, 41));
    }
}
