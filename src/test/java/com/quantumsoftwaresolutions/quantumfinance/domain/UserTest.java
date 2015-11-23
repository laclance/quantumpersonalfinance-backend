package com.quantumsoftwaresolutions.quantumfinance.domain;

import com.quantumsoftwaresolutions.quantumfinance.conf.factory.AccountFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.CashFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.ExpenseFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.UserFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
   private User user;

    @Before
    public void setUp() throws Exception {
       Map<String,String> values = new HashMap<>();
        values.put("username","laclance");
        values.put("password", "123");

        values.put("type", "Food");
        values.put("date", "04/11/2009");
        values.put("frequency", "once");
        List<Item> items = new ArrayList<>();
        items.add(ExpenseFactory.createExpense(values, 100));

        Cash cash = CashFactory.createCash(100, items);

        values.put("acc_no", "123456789");
        values.put("acc_type", "current");
        List<Account> accounts = new ArrayList<>();
        accounts.add(AccountFactory.createAccount(values, 1000, items));

        user =  UserFactory.createUser(values, accounts, cash);
    }

    //@Test
    public void testUser() throws Exception {
        Assert.assertEquals("laclance", user.getUsername());
    }
}
