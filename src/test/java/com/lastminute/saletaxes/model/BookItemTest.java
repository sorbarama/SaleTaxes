package com.lastminute.saletaxes.model;

import com.lastminute.saletaxes.AbstractTest;
import org.junit.*;

/**
 * Created by massimo on 18/05/16.
 */
public class BookItemTest extends AbstractTest {

    public static final String NAME = "the book";
    public static final double PRICE = 12.49d;
    public static final int AMOUNT = 1;
    public static final Boolean IMPORTED = Boolean.FALSE;

    @Before
    public void setUp() throws Exception {
        this.item = new BookItem(NAME, PRICE, AMOUNT, IMPORTED);
    }

    @Test
    public void testBook() {
        Assert.assertEquals(NAME, item.getName());
        Assert.assertEquals(PRICE, item.getPrice(), DELTA);
        Assert.assertEquals(AMOUNT, item.getAmount());
        Assert.assertEquals(IMPORTED, item.getImported());
    }

    @Test
    public void testBookTaxValue() {
        Item item = new BookItem(NAME, PRICE, AMOUNT, Boolean.TRUE);
        Assert.assertEquals(NAME, item.getName());
        Assert.assertEquals(PRICE, item.getPrice(), DELTA);
        Assert.assertEquals(AMOUNT, item.getAmount());
        Assert.assertEquals(Boolean.TRUE, item.getImported());
    }
}