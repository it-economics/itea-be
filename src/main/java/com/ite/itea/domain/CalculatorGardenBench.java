package com.ite.itea.domain;

/*
    Class that calculates price of garden bench AND prints details of the product
 */
public class CalculatorGardenBench {

    private static final double defaultElementPrice = 80;
    private static final double plantElementPrice = 130;
    private static final double woodPlatePrice = 70;
    private static final double backrestPrice = 50;
    private static final double lengthPriceExtraCharge = 1; // 1 euro extra charge for each added cm (if more than 165 cm)

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
        // price calculation for extra length premium
        if(length > 165) {
            productPrice += (length - 165) * lengthPriceExtraCharge;
        }

        // text creation for elements composition
        if(amountPlantElements == 1) {
            elementsText = "Elements: 1 of 2 elements is a plant element";
            totalLength = length + 60;
        } else if(amountPlantElements == 2) {
            elementsText = "Elements: 2 of 2 elements is a plant element";
            totalLength = length + 108;
        } else {
            elementsText = "Elements: 0 of 2 elements is a plant element";
            totalLength = length + 16;
        }
        if(hasBackrest) {
            elementsText += ", has a backrest\n";
        } else {
            elementsText += ", has no backrest\n";
        }

        // price calculation for elements
        productPrice += (amountDefaultElements * defaultElementPrice) + (amountPlantElements * plantElementPrice);
        // price calculation for wood plate
        productPrice += woodPlatePrice;
        // price calculation for backrest
        if(hasBackrest) {
            productPrice += backrestPrice;
        }

        // price calculation for delivery (dependent on weight and length of product)
        if(isDelivery) {
            if(length<=200 && amountDefaultElements==2 && amount==1) {
                deliveryPrice += 70;
            } else if(length<=200 && amountDefaultElements==1 && amount==1) {
                deliveryPrice = 80;
            } else if(length<=200 && amountDefaultElements==0 && amount==1) {
                deliveryPrice = 90;
            } else if(length>200 && amountDefaultElements==2 && amount==1) {
                deliveryPrice = 100;
            } else if(length>200 && amountDefaultElements==1 && amount==1) {
                deliveryPrice = 110;
            } else if(length>200 && amountDefaultElements==0 && amount==1) {
                deliveryPrice = 120;
            } else {
                deliveryPrice = 130;
            }
        } else {
            deliveryPrice = 0;
        }

        // text creation for delivery
        if(isDelivery) {
            deliveryText = "Delivery Type: Product is delivered ";
        }
        else {
            deliveryText = "Delivery Type: Product is collected ";
        }
        deliveryText += "for " + deliveryPrice + " EUR\n";

        productText = "Order for a garden bench:\n";
        productText += elementsText;
        productText += "Total length: " + totalLength + " cm\n";
        productText += deliveryText;
        productText += "Total price (without delivery): " + amount + " * " + productPrice + " EUR = " + (amount*productPrice) + " EUR";
        productText += "\n";
        // TODO: (later/some day in the future) create PDF with productText
        System.out.println(productText);
    }

    public String getProductText() {
        return productText;
    }

    public double getTotalPrice() {
        return amount * productPrice + deliveryPrice;
    }
}
