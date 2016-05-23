package com.lastminute.saletaxes.shop;

import com.lastminute.saletaxes.model.*;
import com.lastminute.saletaxes.sale.CashRegister;

/**
 * Created by massimo on 19/05/16.
 */
public class Shop {

    private Store store;
    private CashRegister cashRegister;


    public Shop(String shopName) {
        this.store = new Store();
        this.cashRegister = new CashRegister(shopName);
    }

    public void addItemToShoppingCart(Item item, ShoppingCart shoppingCart) throws StoreException {
        this.store.removeItemFromStore(item);
        shoppingCart.addItem(item);
    }

    public void printReceipt(ShoppingCart shoppingCart) {
        this.cashRegister.payItems(shoppingCart);
        Receipt receipt = this.cashRegister.getReceipt();
        this.cashRegister.printReceipt(receipt);
    }
}
