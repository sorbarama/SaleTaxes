package com.lastminute.saletaxes.model;

import com.lastminute.saletaxes.tax.TaxEnum;

/**
 * Created by massimo on 18/05/16.
 */
public class MedicalItem extends Item {
    public MedicalItem(String name, double price, int amount, boolean imported) {
        super(name, price, amount, imported);
    }

    @Override
    public double getTax() {
        return TaxEnum.TAX_MEDICAL.getTax();
    }

}
