package com.lastminute.saletaxes.model;

import com.lastminute.saletaxes.tax.TaxEnum;

import java.math.BigDecimal;

/**
 * Created by massimo on 18/05/16.
 */
public class GenericItem extends Item {
    public GenericItem(String name, double price, int amount, boolean imported) {
        super(name, price, amount, imported);
    }

    @Override
    public BigDecimal getTax() {
        return TaxEnum.TAX_GENERIC.getTax();
    }

}
