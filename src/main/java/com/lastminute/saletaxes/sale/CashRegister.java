package com.lastminute.saletaxes.sale;

import com.lastminute.saletaxes.model.*;
import com.lastminute.saletaxes.shop.ShoppingCart;

import java.util.List;

public class CashRegister {

    private Cashier cashier;
    private List<Item> itemList;
    private String shopName;

    public CashRegister(String shopName) {
        this.shopName = shopName;
        this.cashier = new Cashier();
    }

    public void payItems(ShoppingCart cart) {
        itemList = cart.getItems();

        for (Item item : itemList) {
            double itemTax = this.cashier.calculateTax(item.getPrice(), item.getTax(), item.getImported());
            double taxedCost = this.cashier.calcTotalItemCost(item.getPrice(), itemTax);

            item.setTotalCost(taxedCost);
        }
    }

    public Receipt getReceipt() {
        double totalTax = this.cashier.calcTotalTax(this.itemList);
        double totalAmount = this.cashier.calcTotalAmount(this.itemList);
        return this.cashier.createNewReceipt(this.shopName, this.itemList, totalTax, totalAmount);
    }

    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.toString());
    }

}
