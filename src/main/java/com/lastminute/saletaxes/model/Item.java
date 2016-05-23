package com.lastminute.saletaxes.model;

/**
 * Created by massimo on 18/05/16.
 */
public abstract class Item {

    protected String name;

    protected double price;

    protected int amount;

    protected Boolean imported;

    protected double totalCost;

    public Item(String name, double price, int amount, Boolean imported) {
        this.name = name;
        this.price = price * amount;
        this.amount = amount;
        this.imported = imported;
    }

    public abstract double getTax();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Boolean getImported() {
        return this.imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return (this.amount + importString(this.imported) + " " + this.name + ": " + this.totalCost);

    }

    private String importString(Boolean imported) {
        if (imported) {
            return " Imported";
        } else {
            return "";
        }
    }
}
