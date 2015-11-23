package com.quantumsoftwaresolutions.quantumfinance.domain;

import com.quantumsoftwaresolutions.quantumfinance.conf.factory.CashFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.ExpenseFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashTest {
    private Cash cash;

    @Before
    public void setUp() throws Exception {
        Map<String,String> values = new HashMap<>();
        values.put("type", "Food");
        values.put("date", "04/11/2009");
        values.put("frequency", "once");

        List<Item> items = new ArrayList<>();
        items.add(ExpenseFactory.createExpense(values, 100.0));

        cash = CashFactory.createCash(100.0, items);
    }

   // @Test
    public void testCash() throws Exception {
        Assert.assertEquals(100.0, cash.getBalance(), 1);
    }
}
