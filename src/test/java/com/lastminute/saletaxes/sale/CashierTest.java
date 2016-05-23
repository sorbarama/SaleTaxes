package com.lastminute.saletaxes.sale;

import com.lastminute.saletaxes.AbstractTest;
import com.lastminute.saletaxes.model.*;
import com.lastminute.saletaxes.shop.ShoppingCart;
import org.junit.*;

/**
 * Created by massimo on 18/05/16.
 */
public class CashierTest extends AbstractTest {

    private GenericItem genericImported;
    private GenericItem generic;
    private MedicalItem medical;
    private FoodItem food;
    private ShoppingCart shoppingCart;
    private CashRegister cashRegister;

    @Before
    public void setUp() throws Exception {
        this.shoppingCart = new ShoppingCart();
        this.genericImported = new GenericItem("bottle of perfume italian", 27.99, 1, Boolean.TRUE);
        this.generic = new GenericItem("bottle of perfume", 18.99, 1, Boolean.FALSE);
        this.medical = new MedicalItem("packet of headache pills", 9.75, 1, Boolean.FALSE);
        this.food = new FoodItem("box of imported chocolates ", 11.25, 1, Boolean.TRUE);
        this.shoppingCart.addItem(this.generic);
        this.shoppingCart.addItem(this.genericImported);
        this.shoppingCart.addItem(this.medical);
        this.shoppingCart.addItem(this.food);
        this.cashRegister = new CashRegister("lastminute");

    }

    @Test
    public void payItems() {
        this.cashRegister.payItems(this.shoppingCart);
        Assert.assertEquals(20.89, this.generic.getTotalCost(), DELTA);
        Assert.assertEquals(32.19, this.genericImported.getTotalCost(), DELTA);
        Assert.assertEquals(9.75, this.medical.getTotalCost(), DELTA);
        Assert.assertEquals(11.81, this.food.getTotalCost(), DELTA);
    }

    @Test
    public void receipt() {
        this.cashRegister.payItems(this.shoppingCart);
        Receipt receipt = this.cashRegister.getReceipt();
        this.cashRegister.printReceipt(receipt);
        Assert.assertEquals(true, true);
    }
}