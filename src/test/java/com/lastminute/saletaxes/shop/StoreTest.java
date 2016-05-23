package com.lastminute.saletaxes.shop;

import com.lastminute.saletaxes.model.*;
import org.junit.*;

public class StoreTest {

    public Store initStore() {

        Store store = new Store();

        store.addItemToStore(CategoryEnum.CATEGORY_BOOK, new BookItem("the book", 12.49d, 100, Boolean.FALSE));
        store.addItemToStore(CategoryEnum.CATEGORY_FOOD, new FoodItem("box of chocolates", 45.00d, 100, Boolean.FALSE));
        store.addItemToStore(CategoryEnum.CATEGORY_MEDICAL, new MedicalItem("packet of headache pills", 9.75d, 100, Boolean.FALSE));
        store.addItemToStore(CategoryEnum.CATEGORY_GENERIC, new GenericItem("music CD", 9.75d, 100, Boolean.FALSE));

        return store;
    }

    @Test
    public void addItemToStore() {
        Store store = initStore();
        Assert.assertEquals(4, store.getStoreItemsSize());
    }

    @Test
    public void removeItemToStore() {
        Store store = initStore();
        Item book = new BookItem("the book", 12.49d, 1, Boolean.FALSE);
        try {
            store.removeItemFromStore(book);
            Item item = store.findItem(CategoryEnum.CATEGORY_BOOK);
            Assert.assertEquals(99, item.getAmount());

            item = store.findItem(CategoryEnum.CATEGORY_FOOD);
            Assert.assertEquals(100, item.getAmount());

            item = store.findItem(CategoryEnum.CATEGORY_MEDICAL);
            Assert.assertEquals(100, item.getAmount());

            item = store.findItem(CategoryEnum.CATEGORY_GENERIC);
            Assert.assertEquals(100, item.getAmount());

        } catch (StoreException e) {
            Assert.assertEquals(1, 0);
        }
    }

    @Test
    public void removeItemToStoreButExceeded() {
        Store store = initStore();
        Item book = new BookItem("the book", 12.49d, 101, Boolean.FALSE);
        try {
            store.removeItemFromStore(book);
        } catch (StoreException e) {
            Item item = store.findItem(CategoryEnum.CATEGORY_BOOK);
            Assert.assertEquals(100, item.getAmount());
        }
    }

    @Test
    public void findItem() {
        Store store = initStore();
        Item item = store.findItem(CategoryEnum.CATEGORY_FOOD);
        Assert.assertEquals(100, item.getAmount());
    }

}
