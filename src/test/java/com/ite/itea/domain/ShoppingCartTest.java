package com.ite.itea.domain;

import com.ite.itea.domain.core.EuroPrice;
import com.ite.itea.domain.retail.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {

    @Test
    void emptyCart_hasPriceOfZeroCents() {
        final var emptyCart = ShoppingCart.empty();

        assertThat(emptyCart.price()).isEqualTo(EuroPrice.ofCents(0));
    }
}
