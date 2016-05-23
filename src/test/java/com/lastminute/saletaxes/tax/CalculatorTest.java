package com.lastminute.saletaxes.tax;

import com.lastminute.saletaxes.AbstractTest;
import org.junit.*;

import java.math.BigDecimal;

import static com.lastminute.saletaxes.tax.TaxEnum.*;
/**
 * Created by massimo on 18/05/16.
 */
public class CalculatorTest extends AbstractTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        this.calculator = new Calculator();
    }

    @Test
    public void calculateTax() {
        double tax = this.calculator.calculateTax(27.99, TAX_GENERIC.getTax(), Boolean.TRUE);
        Assert.assertEquals(4.2, tax, DELTA);

        tax = this.calculator.calculateTax(12.49d, TAX_BOOK.getTax(), Boolean.TRUE);
        Assert.assertEquals(0.65, tax, DELTA);

        tax = this.calculator.calculateTax(14.99d, TAX_GENERIC.getTax(), Boolean.FALSE);
        Assert.assertEquals(1.5, tax, DELTA);

        tax = this.calculator.calculateTax(14.99d, TAX_GENERIC.getTax(), Boolean.TRUE);
        Assert.assertEquals(2.25, tax, DELTA);

        tax = this.calculator.calculateTax(47.5d, TAX_GENERIC.getTax(), Boolean.TRUE);
        Assert.assertEquals(7.15, tax, DELTA);

        tax = this.calculator.calculateTax(11.25d, TAX_BOOK.getTax(), Boolean.TRUE);
        Assert.assertEquals(0.6, tax, DELTA);
    }

    @Test
    public void truncate() {
        double truncated = this.calculator.truncate(32.123456);
        Assert.assertEquals(32.12, truncated, DELTA);
    }

    @Test
    public void roundTo2Decimals() {
        double rounded = this.calculator.roundTo2Decimals(new BigDecimal("123.13698"));
        Assert.assertEquals(123.15, rounded, DELTA);

        rounded = this.calculator.roundTo2Decimals(new BigDecimal("123.17798"));
        Assert.assertEquals(123.2, rounded, DELTA);
    }
}