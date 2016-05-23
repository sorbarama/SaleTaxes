package com.lastminute.saletaxes.shop;

import com.lastminute.saletaxes.model.Item;

import java.util.*;

/**
 * Created by massimo on 18/05/16.
 */
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
