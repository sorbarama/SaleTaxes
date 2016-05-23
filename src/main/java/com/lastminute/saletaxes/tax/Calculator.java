package com.lastminute.saletaxes.tax;

import java.math.BigDecimal;
import java.text.*;
import java.util.Locale;

public class Calculator {

    public static double truncate(double value) {
        String result = String.format(Locale.ENGLISH, "%.2f", value);
        return Double.parseDouble(result);
    }

    double roundTo2Decimals(BigDecimal value) {
        value = value.setScale(2, BigDecimal.ROUND_HALF_UP);

        BigDecimal d1 = value.setScale(1, BigDecimal.ROUND_DOWN);

        //extract the second digit
        int d1_d = (d1.subtract(value).multiply(BigDecimal.valueOf(100)).abs().toBigInteger()).intValue();

        //rounded up to the nearest 0.05
        switch (d1_d){
            case 1:
            case 2:
            case 3:
            case 4:
                return value.setScale(1, BigDecimal.ROUND_DOWN).add(BigDecimal.valueOf(0.05)).doubleValue();
            case 6:
            case 7:
            case 8:
            case 9:
                return value.setScale(1, BigDecimal.ROUND_UP).doubleValue();
            default:
                return value.doubleValue();
        }

    }

    public double calculateTax(double price, BigDecimal tax, Boolean imported) {

        BigDecimal bigDecimalPrice = BigDecimal.valueOf(price);
        double toReturn = roundTo2Decimals(bigDecimalPrice.multiply(tax));

        if (imported) {
            toReturn += roundTo2Decimals(bigDecimalPrice.multiply(TaxEnum.TAX_IMPORT.getTax()));
        }

        return toReturn;
    }

}
