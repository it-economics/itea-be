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
        String elementsText = "";
        if (amountPlantElements == 1) {
            elementsText = "Elements: 1 of 2 elements is a plant element";
        } else if (amountPlantElements == 2) {
            elementsText = "Elements: 2 of 2 elements is a plant element";
        } else {
            elementsText = "Elements: 0 of 2 elements is a plant element";
        }
        if (hasBackrest) {
            elementsText += ", has a backrest\n";
        } else {
            elementsText += ", has no backrest\n";
        }
        return elementsText;
    }

    private String createDeliveryText(boolean isDelivery, double deliveryPrice) {
        String deliveryText = "";
        if (isDelivery) {
            deliveryText = "Delivery Type: Product is delivered ";
        } else {
            deliveryText = "Delivery Type: Product is collected ";
        }
        deliveryText += "for " + deliveryPrice + " EUR\n";
        return deliveryText;
    }

    private int calculateDeliveryPrice(boolean isDelivery, int length, int amountDefaultElements) {
        int deliveryPrice = 0;

        if (isDelivery) {
            if (length <= 200 && amountDefaultElements == 2) {
                deliveryPrice += 70;
            } else if (length <= 200 && amountDefaultElements == 1) {
                deliveryPrice = 80;
            } else if (length <= 200 && amountDefaultElements == 0) {
                deliveryPrice = 90;
            } else if (length > 200 && amountDefaultElements == 2) {
                deliveryPrice = 100;
            } else if (length > 200 && amountDefaultElements == 1) {
                deliveryPrice = 110;
            } else if (length > 200 && amountDefaultElements == 0) {
                deliveryPrice = 120;
            } else {
                deliveryPrice = 130;
            }
        } else {
            deliveryPrice = 0;
        }
        return deliveryPrice;
    }

    private int calculateTotalLength(int amountPlantElements, int length) {
        int calculatedLength = 0;
        if (amountPlantElements == 1) {
            calculatedLength = length + 60;
        } else if (amountPlantElements == 2) {
            calculatedLength = length + 108;
        } else {
            calculatedLength = length + 16;
        }
        return calculatedLength;
    }

    private boolean isExtraLength(int length) {
        return length > STANDARD_LENGTH_IN_CM;
    }
}
