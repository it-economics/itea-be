package com.ite.itea.domain;

import java.math.BigDecimal;

/*
    Class that calculates price of garden bench AND prints details of the product
 */
public class CalculatorGardenBench {

    private static final BigDecimal DEFAULT_ELEMENT_PRICE = new BigDecimal(80);
    private static final BigDecimal PLANT_ELEMENT_PRICE = new BigDecimal(130);
    ;
    private static final BigDecimal WOOD_PLATE_PRICE = new BigDecimal(70);
    ;
    private static final BigDecimal BACKREST_PRICE = new BigDecimal(50);
    ;
    /**
     * 1 euro extra charge for each added cm (if more than 165 cm)
     */
    private static final BigDecimal LENGTH_PRICE_EXTRA_CHARGE = new BigDecimal(1);
    ;

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

    private BigDecimal productPrice = new BigDecimal(0);
    private BigDecimal deliveryPrice = new BigDecimal(0);

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
        // price calculation for extra length premium
        if (length > 165) {
            productPrice = productPrice.add(new BigDecimal(length - 165).multiply(LENGTH_PRICE_EXTRA_CHARGE));
        }

        // text creation for elements composition
        generateElementText();
        adjustTotalLength();

        // price calculation for elements
        productPrice = productPrice.add((new BigDecimal(amountDefaultElements).multiply(DEFAULT_ELEMENT_PRICE)).add((new BigDecimal(amountPlantElements).multiply(PLANT_ELEMENT_PRICE))));
        // price calculation for wood plate
        productPrice = productPrice.add(WOOD_PLATE_PRICE);
        // price calculation for backrest
        if (hasBackrest) {
            productPrice = productPrice.add(BACKREST_PRICE);
        }

        // price calculation for delivery (dependent on weight and length of product)
        if (isDelivery) {
            if (length <= 200 && amountDefaultElements == 2 && amount == 1) {
               deliveryPrice= deliveryPrice.add(new BigDecimal(70));
            } else if (length <= 200 && amountDefaultElements == 1 && amount == 1) {
                deliveryPrice = new BigDecimal(80);
            } else if (length <= 200 && amountDefaultElements == 0 && amount == 1) {
                deliveryPrice = new BigDecimal(90);
            } else if (length > 200 && amountDefaultElements == 2 && amount == 1) {
                deliveryPrice = new BigDecimal(100);
            } else if (length > 200 && amountDefaultElements == 1 && amount == 1) {
                deliveryPrice = new BigDecimal(110);
            } else if (length > 200 && amountDefaultElements == 0 && amount == 1) {
                deliveryPrice = new BigDecimal(120);
            } else {
                deliveryPrice = new BigDecimal(130);
            }
        } else {
            deliveryPrice = new BigDecimal(0);
        }

        // text creation for delivery
        generateDeliveryText();

        productText = "Order for a garden bench:\n";
        productText += elementsText;
        productText += "Total length: " + totalLength + " cm\n";
        productText += deliveryText;
        productText += "Total price (without delivery): " + amount + " * " + productPrice + " EUR = " + (new BigDecimal(amount).multiply(productPrice)) + " EUR";
        productText += "\n";
        // TODO: (later/some day in the future) create PDF with productText
        System.out.println(productText);
    }

    private void generateDeliveryText() {
        String deliveredOrCollected = (isDelivery) ? "delivered" : "collected";
        deliveryText = "Delivery Type: Product is " + deliveredOrCollected + " for " + deliveryPrice + " EUR\n";
    }

    private void adjustTotalLength() {
        if (amountPlantElements == 1) {
            totalLength = length + 60;
        } else if (amountPlantElements == 2) {
            totalLength = length + 108;
        } else {
            totalLength = length + 16;
        }
    }

    private void generateElementText() {
        String hasBackrestText = hasBackrest ? "a" : "no";
        elementsText = "Elements: " + amountPlantElements + " of 2 elements is a plant element, has " + hasBackrestText + " backrest\n";
    }

    public String getProductText() {
        return productText;
    }

    public BigDecimal getTotalPrice() {
        return new BigDecimal(amount).multiply(productPrice).add(deliveryPrice);
    }
}
