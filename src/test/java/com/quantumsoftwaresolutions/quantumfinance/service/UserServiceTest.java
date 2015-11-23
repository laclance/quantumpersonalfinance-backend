package com.quantumsoftwaresolutions.quantumfinance.service;

import com.quantumsoftwaresolutions.quantumfinance.App;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.AccountFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.CashFactory;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.ExpenseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import com.quantumsoftwaresolutions.quantumfinance.conf.factory.UserFactory;
import com.quantumsoftwaresolutions.quantumfinance.domain.*;
import com.quantumsoftwaresolutions.quantumfinance.repository.UserRepository;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repository;

    private Long id;;
    private User user;

  //  @BeforeClass
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
        id=user.getId();
        Assert.assertNotNull(user.getId());
    }

  //  @Test(dependsOnMethods = "create")
    public void testFindByUsername() throws Exception {
        User user2 = service.findByUsername(user.getUsername());
        Assert.assertNotNull(user2);
    }

  //  @Test(dependsOnMethods = "testFindByUsername")
    public void testGetUser() throws Exception {
        User findUser = service.findById(id);
        Assert.assertNotNull(findUser);
    }

//    @Test(dependsOnMethods = "testGetUser")
    public void testGetUsers() throws Exception {
        List<User> users = service.findAll();
        Assert.assertTrue(users.size() == 1);
    }

 //   @AfterClass
    public void tearDown() throws Exception {
        repository.deleteAll();
    }
}

