package com.lastminute.saletaxes.tax;

import com.lastminute.saletaxes.AbstractTest;
import org.junit.*;

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
        double tax = this.calculator.calculateTax(12.49d, 0.0d, false);
        Assert.assertEquals(0, tax, DELTA);

        tax = this.calculator.calculateTax(12.49d, 0.0d, true);
        Assert.assertEquals(0.62, tax, DELTA);

        tax = this.calculator.calculateTax(14.99d, 0.10d, false);
        Assert.assertEquals(1.5, tax, DELTA);

        tax = this.calculator.calculateTax(14.99d, 0.10d, true);
        Assert.assertEquals(2.25, tax, DELTA);
    }

    @Test
    public void truncate() {
        double truncated = this.calculator.truncate(32.123456);
        Assert.assertEquals(32.12, truncated, DELTA);
    }

    @Test
    public void roundoff() {
        double rounded = this.calculator.roundoff(123.13698);
        Assert.assertEquals(123.14, rounded, DELTA);

        rounded = this.calculator.roundoff(123.13198);
        Assert.assertEquals(123.13, rounded, DELTA);
    }
}