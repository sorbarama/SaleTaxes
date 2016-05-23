package com.lastminute.saletaxes.tax;

/**
 * Created by massimo on 18/05/16.
 */
public enum TaxEnum {

    TAX_BOOK(0.0),
    TAX_FOOD(0.0),
    TAX_MEDICAL(0.0),
    TAX_GENERIC(0.10),
    TAX_IMPORT(0.05);

    private double value;

    TaxEnum(double value) {
        this.value = value;
    }

    public double getTax() {
        return value;
    }
}
