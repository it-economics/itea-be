package com.ite.itea.ecommerce.domain.invoicing;

import com.ite.itea.ecommerce.domain.core.EuroPrice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest {

    @Test
    void vatRate() {
        LineItem item = new LineItem(
                "Test Item",
                EuroPrice.ofEurosAndCents(100, 0),
                Quantity.of(1),
                VatRate.COVID_STANDARD
        );

        assertEquals(VatRate.COVID_STANDARD, item.vatRate());
        assertNotEquals(VatRate.REDUCED, item.vatRate());
        assertNotEquals(VatRate.STANDARD, item.vatRate());
    }
}