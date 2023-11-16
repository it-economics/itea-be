package com.ite.itea.ecommerce.domain.invoicing;

class Quantity {

    public final int value;

    private Quantity(int value) {
        if (value < 0) {
            throw new NegativeQuantityException();
        }

        this.value = value;
    }

    public static Quantity of(int value) {
        return new Quantity(value);
    }

    private class NegativeQuantityException extends RuntimeException {

        public NegativeQuantityException() {
            super("Value of quantity must be non-negative.");
        }
    }
}
