package com.lastminute.saletaxes.model;

import java.util.*;

/**
 * Created by massimo on 19/05/16.
 */
public class Receipt {
    private static long sequence = 0l;
    private final double totalTax;
    private final double totalAmount;

    private Date date;
    private Long progressive = nextVal();
    private String shopName;
    private List<Item> items;

    public Receipt(Date date, String shopName, List<Item> items, double tax, double amount) {
        this.date = date;
        this.shopName = shopName;
        this.items = items;
        this.totalTax = tax;
        this.totalAmount = amount;
    }

    private long nextVal() {
        this.sequence += 1l;
        return this.sequence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(4);

        sb.append("############################").append("\n");
        sb.append(this.shopName).append("\n");
        sb.append("############################").append("\n");
        sb.append("Date :").append(this.date).append("\n");
        sb.append("Num. :").append(this.progressive).append("\n\n");
        sb.append("############################").append("\n");

        for (Item item : this.items) {
            sb.append(item.toString() + "\n");
        }

        sb.append("############################").append("\n");
        sb.append("Sales tax = ").append(this.totalTax).append("\n");
        sb.append("Total = ").append(totalAmount).append("\n");
        sb.append("############################").append("\n");

        return sb.toString();
    }
}
