package com.ite.itea.domain;

/*
    Class that calculates price of garden bench AND prints details of the product
 */
public class CalculatorGardenBench {

    private static final double DEFAULT_ELEMENT_PRICE = 80;
    private static final double PLANT_ELEMENT_PRICE = 130;
    private static final double WOOD_PLATE_PRICE = 70;
    private static final double BACKREST_PRICE = 50;
    /**
     * 1 euro extra charge for each added cm (if more than 165 cm)
     */
    private static final double LENGTH_PRICE_EXTRA_CHARGE = 1;

    private String elementsText;
    private String deliveryText;
    private String productText;

    private int amount;
    private int length;
    private int totalLength;

    private int amountDefaultElements;
    private int amountPlantElements;
    private boolean hasBackrest;
    private boolean isDelivery;

    private double productPrice;
    private double deliveryPrice = 0;

    public CalculatorGardenBench(int amount, int length, int amountDefaultElements, int amountPlantElements, boolean hasBackrest, boolean isDelivery) {
        this.amount = amount;
        this.length = length;
        this.amountDefaultElements = amountDefaultElements;
        this.amountPlantElements = amountPlantElements;
        this.hasBackrest = hasBackrest;
        this.isDelivery = isDelivery;

        calculateAndPrint();
    }

    private void calculateAndPrint() {

        //TODO: refactoring: get rid of implicit variable initialization
        int totalLength = calculateTotalLength(amountPlantElements, length);
        String elementsText = createElementsText(amountPlantElements, hasBackrest);
        productPrice = calculateProductPrice(length, amountDefaultElements, amountPlantElements, hasBackrest);

        deliveryPrice = calculateDeliveryPrice(isDelivery, length, amountDefaultElements, amount);
        String deliveryText = createDeliveryText(isDelivery, deliveryPrice);

        productText= calculateProductText(elementsText, totalLength, deliveryText, amount, productPrice);
        // TODO: (later/some day in the future) create PDF with productText
        System.out.println(productText);
    }

    private String calculateProductText(String elementsText, int totalLength, String deliveryText, int amount, double productPrice) {
        String productText = "Order for a garden bench:\n";
        productText += elementsText;
        productText += "Total length: " + totalLength + " cm\n";
        productText += deliveryText;
        productText += "Total price (without delivery): " + amount + " * " + productPrice + " EUR = " + (amount * productPrice) + " EUR";
        productText += "\n";
        return productText;
    }

    private double calculateProductPrice(int length, int amountDefaultElements, int amountPlantElements, boolean hasBackrest) {
        double productPrice=0.0;
        if (isExtraLength(length)) {
            productPrice += (length - 165) * LENGTH_PRICE_EXTRA_CHARGE;
        }
        // price calculation for elements
        productPrice += (amountDefaultElements * DEFAULT_ELEMENT_PRICE) + (amountPlantElements * PLANT_ELEMENT_PRICE);
        // price calculation for wood plate
        productPrice += WOOD_PLATE_PRICE;
        // price calculation for backrest
        if (hasBackrest) {
            productPrice += BACKREST_PRICE;
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

    private int calculateDeliveryPrice(boolean isDelivery, int length, int amountDefaultElements, int amount) {
        int deliveryPrice = 0;

        if (isDelivery) {
            if (length <= 200 && amountDefaultElements == 2 && amount == 1) {
                deliveryPrice += 70;
            } else if (length <= 200 && amountDefaultElements == 1 && amount == 1) {
                deliveryPrice = 80;
            } else if (length <= 200 && amountDefaultElements == 0 && amount == 1) {
                deliveryPrice = 90;
            } else if (length > 200 && amountDefaultElements == 2 && amount == 1) {
                deliveryPrice = 100;
            } else if (length > 200 && amountDefaultElements == 1 && amount == 1) {
                deliveryPrice = 110;
            } else if (length > 200 && amountDefaultElements == 0 && amount == 1) {
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
        return length > 165;
    }

    public String getProductText() {
        return productText;
    }

    public double getTotalPrice() {
        return amount * productPrice + deliveryPrice;
    }
}
