package com.lastminute.saletaxes.shop;

import com.lastminute.saletaxes.model.*;
import org.junit.*;

public class ShopTest {

    private Shop shop = new Shop("lastminute");

    @Test
    public void firstOut() {
        StoreTest storeTest = new StoreTest();
        storeTest.initStore();

        ShoppingCart shoppingCart = new ShoppingCart();

        try {
            Item book = new BookItem("the book", 12.49d, 1, Boolean.FALSE);
            this.shop.addItemToShoppingCart(book, shoppingCart);
            Assert.assertEquals(1, shoppingCart.getItems().size());

            Item cd = new GenericItem("music CD", 14.99d, 1, Boolean.FALSE);
            this.shop.addItemToShoppingCart(cd, shoppingCart);
            Assert.assertEquals(2, shoppingCart.getItems().size());

            Item chocolateBar = new FoodItem("chocolate bar", 0.85d, 1, Boolean.FALSE);
            this.shop.addItemToShoppingCart(chocolateBar, shoppingCart);
            Assert.assertEquals(3, shoppingCart.getItems().size());

            this.shop.printReceipt(shoppingCart);

        } catch (StoreException e) {
            Assert.assertEquals(1, 0);
        }
    }

    @Test
    public void secondOut() {
        StoreTest storeTest = new StoreTest();
        storeTest.initStore();

        ShoppingCart shoppingCart = new ShoppingCart();

        try {
            Item chocolateBar = new FoodItem("box of chocolate", 10.0d, 1, Boolean.TRUE);
            this.shop.addItemToShoppingCart(chocolateBar, shoppingCart);
            Assert.assertEquals(1, shoppingCart.getItems().size());

            Item bottleOfPorfume = new GenericItem("bottle of perfume", 47.50d, 1, Boolean.TRUE);
            this.shop.addItemToShoppingCart(bottleOfPorfume, shoppingCart);
            Assert.assertEquals(2, shoppingCart.getItems().size());

            this.shop.printReceipt(shoppingCart);

        } catch (StoreException e) {
            Assert.assertEquals(1, 0);
        }
    }

    @Test
    public void thirdOut() {
        StoreTest storeTest = new StoreTest();
        storeTest.initStore();

        ShoppingCart shoppingCart = new ShoppingCart();

        try {
            Item bottleOfPorfumeImported = new GenericItem("bottle of perfume", 27.99d, 1, Boolean.TRUE);
            this.shop.addItemToShoppingCart(bottleOfPorfumeImported, shoppingCart);
            Assert.assertEquals(1, shoppingCart.getItems().size());

            Item bottleOfPorfume = new GenericItem("bottle of perfume", 18.99d, 1, Boolean.FALSE);
            this.shop.addItemToShoppingCart(bottleOfPorfume, shoppingCart);
            Assert.assertEquals(2, shoppingCart.getItems().size());

            Item packetOfHeadachePills = new MedicalItem("packet of headache pills", 9.75d, 1, Boolean.FALSE);
            this.shop.addItemToShoppingCart(packetOfHeadachePills, shoppingCart);
            Assert.assertEquals(3, shoppingCart.getItems().size());

            Item boxOfImportedChocolates = new FoodItem("box of chocolates", 11.25d, 1, Boolean.TRUE);
            this.shop.addItemToShoppingCart(boxOfImportedChocolates, shoppingCart);
            Assert.assertEquals(4, shoppingCart.getItems().size());

            this.shop.printReceipt(shoppingCart);

        } catch (StoreException e) {
            Assert.assertEquals(1, 0);
        }
    }

}
