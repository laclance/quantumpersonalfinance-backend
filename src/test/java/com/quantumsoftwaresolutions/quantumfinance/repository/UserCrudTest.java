package com.quantumsoftwaresolutions.quantumfinance.repository;

import com.quantumsoftwaresolutions.quantumfinance.conf.factory.AccountFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.CashFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.ExpenseFactory;
import com.quantumsoftwaresolutions.quantumfinance.domain.Account;
import com.quantumsoftwaresolutions.quantumfinance.domain.Cash;
import com.quantumsoftwaresolutions.quantumfinance.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import com.quantumsoftwaresolutions.quantumfinance.conf.factory.UserFactory;
import com.quantumsoftwaresolutions.quantumfinance.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class UserCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private User user;

    @Autowired //only not commented
    private UserRepository repository;

    //@BeforeClass
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


   // @Test
    public void create() throws Exception {
        repository.save(user);
        id = user.getId();
        Assert.assertNotNull(user.getId());
    }

   // @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User findUser = repository.findOne(id);
        Assert.assertNotNull(findUser.getId());
        Assert.assertEquals(findUser.getUsername(), "laclance");
    }

  //  @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User findUser = repository.findOne(id);

        User newUser = new User.Builder()
                .copy(findUser)
                .password("1234")
                .build();

        repository.save(newUser);
        User updatedUser = repository.findOne(id);
        Assert.assertEquals("1234", updatedUser.getPassword());
    }

   // @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User findUser = repository.findOne(id);
        repository.delete(findUser);

        User deletedUser = repository.findOne(id);
        Assert.assertNull(deletedUser);
    }
}
