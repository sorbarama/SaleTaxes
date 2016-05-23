package com.lastminute.saletaxes.shop;

/**
 * Created by massimo on 18/05/16.
 */
public enum CategoryEnum {

    CATEGORY_BOOK("Book"),
    CATEGORY_FOOD("Food"),
    CATEGORY_MEDICAL("Medical"),
    CATEGORY_GENERIC("Generic");

    private String name;

    CategoryEnum(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.name;
    }
}
