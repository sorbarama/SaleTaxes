package com.lastminute.saletaxes.tax;

import java.util.Locale;

public class Calculator {

    public static final double DOUBLE_100 = 100.0;

    public static double truncate(double value) {
        String result = String.format(Locale.ENGLISH, "%.2f", value);
        return Double.parseDouble(result);
    }

    public static double roundoff(double value) {
        return Math.round(value * DOUBLE_100) / DOUBLE_100;
    }

    public double calculateTax(double price, double tax, Boolean imported) {

        double toReturn = price * tax;

        if (imported) {
            toReturn += (price * TaxEnum.TAX_IMPORT.getTax());
        }

        toReturn = roundoff(toReturn);

        return toReturn;
    }

}
