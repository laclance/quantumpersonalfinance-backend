package com.quantumsoftwaresolutions.quantumfinance.domain;

import com.quantumsoftwaresolutions.quantumfinance.conf.factory.AccountFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.ExpenseFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() throws Exception {
        Map<String,String> values = new HashMap<>();
        values.put("type", "Food");
        values.put("date", "04/11/2009");
        values.put("frequency", "once");

        List<Item> items = new ArrayList<>();
        items.add(ExpenseFactory.createExpense(values, 100));

        values.put("acc_no", "123456789");
        values.put("acc_type", "current");
        account = AccountFactory.createAccount(values, 1000, items);
    }

   // @Test
    public void testUser() throws Exception {
        Assert.assertEquals("123456789", account.getAcc_no());
    }
}
