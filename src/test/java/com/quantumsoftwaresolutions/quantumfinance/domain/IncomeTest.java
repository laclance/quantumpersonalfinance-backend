package com.quantumsoftwaresolutions.quantumfinance.domain;

import com.quantumsoftwaresolutions.quantumfinance.conf.factory.IncomeFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

public class IncomeTest {
    Item item;

    @Before
    public void setUp() throws Exception {
        Map<String,String> values = new HashMap<>();
        values.put("type", "Food");
        values.put("date", "04/11/2009");
        values.put("frequency", "once");

        item = IncomeFactory.createIncome(values, 100.0);
    }

   // @Test
    public void testCash() throws Exception {
        Assert.assertEquals(100.0, item.getAmount(), 1);
    }
}
