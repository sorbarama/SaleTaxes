package com.lastminute.saletaxes.shop;

import com.lastminute.saletaxes.model.*;
import org.junit.*;

public class ShoppingCartTest {

    public static final String NAME = "music CD";
    public static final double PRICE = 14.99d;
    public static final int AMOUNT = 1;
    public static final Boolean IMPORTED = Boolean.FALSE;

    private ShoppingCart shoppingCart;
    private Item item;

    @Before
    public void setUp() {
        this.shoppingCart = new ShoppingCart();
        this.item = new GenericItem(NAME, PRICE, AMOUNT, IMPORTED);
    }

    @Test
    public void addItemToCart() {
        this.shoppingCart.addItem(item);
        Assert.assertEquals(1, this.shoppingCart.getItems().size());
    }

    @Test
    public void removeItemToCart() {
        this.shoppingCart.addItem(item);
        this.shoppingCart.addItem(item);
        this.shoppingCart.removeItem(item);
        Assert.assertEquals(1, this.shoppingCart.getItems().size());
    }

}
