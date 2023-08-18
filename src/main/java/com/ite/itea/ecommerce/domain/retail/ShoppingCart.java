package com.ite.itea.ecommerce.domain.retail;

import java.util.ArrayList;

public final class ShoppingCart {

    private final ArrayList<CartItem> cartItems = new ArrayList<>();

    private ShoppingCart() {
    }

    public static ShoppingCart empty() {
        return new ShoppingCart();
    }

    public void addProduct(Product product) {
        cartItems.add(new CartItem(product));
    }

    public void addVoucher(Voucher voucher) {
        addProduct(voucher);
    }

    public EuroPrice price() {
        final var totalPriceInCents = totalProductsPrice().asCents() - totalDiscountAmount().asCents();
        return EuroPrice.ofCents(Math.max(0, totalPriceInCents));
    }

    private EuroPrice totalProductsPrice() {
        return cartItems.stream()
                .filter(cartItem -> !(cartItem.product instanceof Voucher))
                .map(cartItem -> cartItem.product.price())
                .reduce(EuroPrice.zero(), EuroPrice::plus);
    }

    private EuroPrice totalDiscountAmount() {
        return cartItems.stream()
                .filter(cartItem -> cartItem.product instanceof Voucher)
                .map(cartItem -> (Voucher) cartItem.product)
                .map(Voucher::discountAmount)
                .reduce(EuroPrice.zero(), EuroPrice::plus);
    }

    private record CartItem(Product product) {
    }
}
