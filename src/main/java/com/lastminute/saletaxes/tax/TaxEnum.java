package com.lastminute.saletaxes.tax;

import java.math.BigDecimal;

/**
 * Created by massimo on 18/05/16.
 */
public enum TaxEnum {

    TAX_BOOK(BigDecimal.ZERO),
    TAX_FOOD(BigDecimal.ZERO),
    TAX_MEDICAL(BigDecimal.ZERO),
    TAX_GENERIC(new BigDecimal("0.1")),
    TAX_IMPORT(new BigDecimal("0.05"));

    private BigDecimal value;

    TaxEnum(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTax() {
        return value;
    }
}
