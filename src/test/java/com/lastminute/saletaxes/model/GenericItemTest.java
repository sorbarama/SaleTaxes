package com.lastminute.saletaxes.model;

import com.lastminute.saletaxes.AbstractTest;
import org.junit.*;

/**
 * Created by massimo on 18/05/16.
 */
public class GenericItemTest extends AbstractTest {

    public static final String NAME = "Musica CD";
    public static final double PRICE = 14.99d;
    public static final int AMOUNT = 1;
    public static final Boolean IMPORTED = Boolean.FALSE;

    @Before
    public void setUp() throws Exception {
        this.item = new GenericItem(NAME, PRICE, AMOUNT, IMPORTED);
    }

    @Test
    public void testGeneric() {
        Assert.assertEquals(NAME, item.getName());
        Assert.assertEquals(PRICE, item.getPrice(), DELTA);
        Assert.assertEquals(AMOUNT, item.getAmount());
        Assert.assertEquals(IMPORTED, item.getImported());
    }

    @Test
    public void testGenericTaxValue() {
        Item item = new GenericItem(NAME, PRICE, AMOUNT, Boolean.TRUE);
        Assert.assertEquals(NAME, item.getName());
        Assert.assertEquals(PRICE, item.getPrice(), DELTA);
        Assert.assertEquals(AMOUNT, item.getAmount());
        Assert.assertEquals(Boolean.TRUE, item.getImported());

    }
}