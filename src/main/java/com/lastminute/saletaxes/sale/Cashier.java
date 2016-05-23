package com.lastminute.saletaxes.sale;

import com.lastminute.saletaxes.model.*;
import com.lastminute.saletaxes.tax.Calculator;

import java.math.BigDecimal;
import java.util.*;

public class Cashier {

    private final Calculator calculator;

    public Cashier() {
        this.calculator = new Calculator();
    }

    public double calculateTax(double price, BigDecimal tax, boolean imported) {

        double totalItemTax = this.calculator.calculateTax(price, tax, imported);
        return totalItemTax;
    }

    public double calcTotalAmount(List<Item> items) {
        double totalAmount = 0.0;

        for (Item p : items) {
            totalAmount += p.getTotalCost();
        }

        return Calculator.truncate(totalAmount);
    }

    public double calcTotalTax(List<Item> prodList) {
        double totalTax = 0.0;

        for (Item p : prodList) {
            totalTax += (p.getTotalCost() - p.getPrice());
        }

        return Calculator.truncate(totalTax);
    }

    public double calcTotalItemCost(double price, double tax) {
        return Calculator.truncate(price + tax);
    }

    public Receipt createNewReceipt(String shopName, List<Item> itemList, double totalTax, double totalAmount) {
        return new Receipt(new Date(), shopName, itemList, totalTax, totalAmount);
    }

}
