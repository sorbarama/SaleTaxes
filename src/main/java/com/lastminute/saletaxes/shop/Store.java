package com.lastminute.saletaxes.shop;

import com.lastminute.saletaxes.model.Item;

import java.util.*;

/**
 * Created by massimo on 22/05/16.
 */
public class Store {

    private HashMap<CategoryEnum, Item> storeItems;

    public Store() {
        this.storeItems = new HashMap<>();
    }

    public int getStoreItemsSize() {
        return this.storeItems.size();
    }

    public void addItemToStore(CategoryEnum category, Item item) {
        this.storeItems.put(category, item);
    }

    public void removeItemFromStore(Item item) throws StoreException {
        removeItem(this.storeItems, item);
    }

    public Item findItem(CategoryEnum categoryEnum) {
        return this.storeItems.get(categoryEnum);
    }

    private void removeItem(HashMap<CategoryEnum, Item> storeItems, Item item) throws StoreException {
        for (Map.Entry<CategoryEnum, Item> entry : storeItems.entrySet()) {

            if (entry.getValue().getName().equals(item.getName())) {
                if (entry.getValue().getAmount() < item.getAmount()) {
                    throw new StoreException("Amount exceeded");
                } else {
                    entry.getValue().setAmount(entry.getValue().getAmount() - item.getAmount());
                }
            }
        }
    }
}
