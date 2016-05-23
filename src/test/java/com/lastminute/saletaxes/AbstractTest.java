// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package com.lastminute.saletaxes;

import com.lastminute.saletaxes.model.Item;
import org.junit.After;

/**
 * Created by massimo on 18/05/16.
 */
public abstract class AbstractTest {
    public static final double DELTA = 0.005;
    protected Item item;

    @After
    public void tearDown() throws Exception {
        System.out.println("Test completed!");
    }
}
