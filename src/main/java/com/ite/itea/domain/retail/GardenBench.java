package com.ite.itea.domain.retail;

import com.ite.itea.domain.core.EuroPrice;

public class GardenBench extends Product {

    private static final double DEFAULT_ELEMENT_PRICE_IN_EUR = 80;
    private static final double PLANT_ELEMENT_PRICE_IN_EUR = 130;
    private static final double WOOD_PLATE_PRICE_IN_EUR = 70;
    private static final double BACKREST_PRICE_IN_EUR = 50;
    /**
     * 1 euro extra charge for each added cm (if more than 165 cm)
     */
    private static final double LENGTH_PRICE_EXTRA_CHARGE_IN_EUR = 1;
    private static final int STANDARD_LENGTH_IN_CM = 165;

    private final int length;

    private final int amountDefaultElements;
    private final int amountPlantElements;
    private final boolean hasBackrest;
    private final boolean isDelivery;

    private String productText;

    public GardenBench(ProductId id, int length, int amountDefaultElements, int amountPlantElements, boolean hasBackrest, boolean isDelivery) {
        super(id, "Garden bench");
        this.length = length;
        this.amountDefaultElements = amountDefaultElements;
        this.amountPlantElements = amountPlantElements;
        this.hasBackrest = hasBackrest;
        this.isDelivery = isDelivery;
    }

    @Override
    public EuroPrice price() {
        final var productPrice = calculateProductPrice(length, amountDefaultElements, amountPlantElements, hasBackrest);
        final var deliveryPrice = calculateDeliveryPrice(isDelivery, length, amountDefaultElements);
        final double euros = productPrice + deliveryPrice;
        return EuroPrice.ofCents((long)(euros * 100));
    }

    @Override
    public String description() {
        if (productText==null || productText.isEmpty()) {
            final var productPrice = calculateProductPrice(length, amountDefaultElements, amountPlantElements, hasBackrest);
            final var deliveryPrice = calculateDeliveryPrice(isDelivery, length, amountDefaultElements);
            productText = calculateProductText(productPrice, deliveryPrice, amountPlantElements, length, hasBackrest, isDelivery);
        }
        return productText;
    }

    private String calculateProductText(double productPrice, double deliveryPrice, int amountPlantElements, int length, boolean hasBackrest, boolean isDelivery) {
        int totalLength = calculateTotalLength(amountPlantElements, length);
        String elementsText = createElementsText(amountPlantElements, hasBackrest);
        String deliveryText = createDeliveryText(isDelivery, deliveryPrice);

        String productText = "Order for a garden bench:\n";
        productText += elementsText;
        productText += "Total length: " + totalLength + " cm\n";
        productText += deliveryText;
        if (isDelivery) {
            productText += "Total price (without delivery): " + productPrice + " EUR";
            productText += "\n";
            productText += "Total price (including delivery): " + (productPrice + deliveryPrice) + " EUR";
            productText += "\n";
        } else {
            productText += "Total price: " + productPrice + " EUR";
            productText += "\n";
        }
        return productText;
    }

    private double calculateProductPrice(int length, int amountDefaultElements, int amountPlantElements, boolean hasBackrest) {
        double productPrice = 0.0;
        if (isExtraLength(length)) {
            productPrice += (length - STANDARD_LENGTH_IN_CM) * LENGTH_PRICE_EXTRA_CHARGE_IN_EUR;
        }
        // price calculation for elements
        productPrice += (amountDefaultElements * DEFAULT_ELEMENT_PRICE_IN_EUR) + (amountPlantElements * PLANT_ELEMENT_PRICE_IN_EUR);
        // price calculation for wood plate
        productPrice += WOOD_PLATE_PRICE_IN_EUR;
        // price calculation for backrest
        if (hasBackrest) {
            productPrice += BACKREST_PRICE_IN_EUR;
        }
        return productPrice;
    }

    private String createElementsText(int amountPlantElements, boolean hasBackrest) {
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

    private String createDeliveryText(boolean isDelivery, double deliveryPrice) {
        String deliveryText = isDelivery
                ? "Delivery Type: Product is delivered "
                : "Delivery Type: Product is collected ";
        return deliveryText + "for " + deliveryPrice + " EUR\n";
    }

    private int calculateDeliveryPrice(boolean isDelivery, int length, int amountDefaultElements) {
        if (!isDelivery) {
            return 0;
        }

        if (length <= 200) {
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

    private int calculateTotalLength(int amountPlantElements, int length) {
        return switch (amountPlantElements) {
            case 1 -> length + 60;
            case 2 -> length + 108;
            default -> length + 16;
        };
    }

    private boolean isExtraLength(int length) {
        return length > STANDARD_LENGTH_IN_CM;
    }
}
