package com.ite.itea.domain.retail;

import com.ite.itea.domain.core.EuroPrice;

public class GardenBench extends Product {

    private static final double DEFAULT_ELEMENT_PRICE_IN_EUR = 80;
    private static final double PLANT_ELEMENT_PRICE_IN_EUR = 130;
    private static final double WOOD_PLATE_PRICE_IN_EUR = 70;
    private static final double BACKREST_PRICE_IN_EUR = 50;

    private final int lengthInCentimeters;

    private final int amountDefaultElements;
    private final int amountPlantElements;
    private final boolean hasBackrest;
    private final boolean isDelivery;

    public GardenBench(ProductId id, int lengthInCentimeters, int amountDefaultElements, int amountPlantElements, boolean hasBackrest, boolean isDelivery) {
        super(id, "Garden bench");
        this.lengthInCentimeters = lengthInCentimeters;
        this.amountDefaultElements = amountDefaultElements;
        this.amountPlantElements = amountPlantElements;
        this.hasBackrest = hasBackrest;
        this.isDelivery = isDelivery;
    }

    @Override
    public EuroPrice price() {
        final var productPrice = calculateProductPrice();
        final var deliveryPrice = calculateDeliveryPrice();
        final double euros = productPrice + deliveryPrice;
        return EuroPrice.ofCents((long)(euros * 100));
    }

    @Override
    public String description() {
        final var productPrice = calculateProductPrice();
        final var deliveryPrice = calculateDeliveryPrice();

        return "Order for a garden bench:\n"
                + formatElementsText(amountPlantElements, hasBackrest)
                + "Total length: " + totalLength(amountPlantElements, lengthInCentimeters) + " cm\n"
                + formatDeliveryText(isDelivery, deliveryPrice)
                + formatDeliveryPriceText(productPrice, deliveryPrice);
    }

    private double calculateProductPrice() {
        final var defaultElementsPrice = amountDefaultElements * DEFAULT_ELEMENT_PRICE_IN_EUR;
        final var plantElementsPrice = amountPlantElements * PLANT_ELEMENT_PRICE_IN_EUR;
        return defaultElementsPrice
                + plantElementsPrice
                + extraLengthPrice()
                + WOOD_PLATE_PRICE_IN_EUR
                + (hasBackrest ? BACKREST_PRICE_IN_EUR : 0);
    }

    private int calculateDeliveryPrice() {
        if (!isDelivery) {
            return 0;
        }

        if (lengthInCentimeters <= 200) {
            switch (amountDefaultElements) {
                case 2: return 70;
                case 1: return 80;
                case 0: return 90;
            }
        } else {
            switch (amountDefaultElements) {
                case 2: return 100;
                case 1: return 110;
                case 0: return 120;
            }
        }

        return 0;
    }

    private double extraLengthPrice() {
        final double lengthPriceExtraChargeInEur = 1.0;
        final int standardLengthInCm = 165;
        if (lengthInCentimeters > standardLengthInCm) {
            return (lengthInCentimeters - standardLengthInCm) * lengthPriceExtraChargeInEur;
        }
        return 0;
    }

    private String formatElementsText(int amountPlantElements, boolean hasBackrest) {
        final var amountPlantElementsText = switch (amountPlantElements) {
            case 1 -> "Elements: 1 of 2 elements is a plant element";
            case 2 -> "Elements: 2 of 2 elements is a plant element";
            default -> "Elements: 0 of 2 elements is a plant element";
        };
        final var backRestText = hasBackrest
                ? ", has a backrest\n"
                : ", has no backrest\n";
        return amountPlantElementsText + backRestText;
    }

    private String formatDeliveryText(boolean isDelivery, double deliveryPrice) {
        String deliveryText = isDelivery
                ? "Delivery Type: Product is delivered "
                : "Delivery Type: Product is collected ";
        return deliveryText + "for " + deliveryPrice + " EUR\n";
    }

    private String formatDeliveryPriceText(double productPrice, double deliveryPrice) {
        if (isDelivery) {
            return "Total price (without delivery): " + productPrice + " EUR\n"
                    + "Total price (including delivery): " + (productPrice + deliveryPrice) + " EUR\n";
        } else {
            return "Total price: " + productPrice + " EUR\n";
        }
    }

    private int totalLength(int amountPlantElements, int length) {
        return switch (amountPlantElements) {
            case 1 -> length + 60;
            case 2 -> length + 108;
            default -> length + 16;
        };
    }
}
