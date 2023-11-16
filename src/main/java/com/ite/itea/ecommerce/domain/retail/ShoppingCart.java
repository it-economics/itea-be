package com.ite.itea.ecommerce.domain.retail;

import com.ite.itea.ecommerce.domain.core.EuroPrice;

import java.util.ArrayList;
import java.util.List;

public final class ShoppingCart {

    private final List<CartItem> cartItems = new ArrayList<>();
    private final List<Voucher> vouchers = new ArrayList<>();

    private ShoppingCart() {
    }

    public static ShoppingCart empty() {
        return new ShoppingCart();
    }

    public void addProduct(Product product) {
        cartItems.add(new CartItem(product));
    }

    public void addVoucher(Voucher voucher) {
        vouchers.add(voucher);
    }

    public EuroPrice price() {
        final var totalPriceInCents = totalProductsPrice().asCents() - totalDiscountAmount().asCents();
        return EuroPrice.ofCents(Math.max(0, totalPriceInCents));
    }

    private EuroPrice totalProductsPrice() {
        return cartItems.stream()
                .map(cartItem -> cartItem.product.price())
                .reduce(EuroPrice.zero(), EuroPrice::plus);
    }

    private EuroPrice totalDiscountAmount() {
        return vouchers.stream()
                .map(Voucher::discountAmount)
                .reduce(EuroPrice.zero(), EuroPrice::plus);
    }

    private record CartItem(Product product) {
    }
}
