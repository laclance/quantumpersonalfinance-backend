package com.quantumsoftwaresolutions.quantumfinance.conf.factory;

import com.quantumsoftwaresolutions.quantumfinance.domain.Account;
import com.quantumsoftwaresolutions.quantumfinance.domain.Cash;
import com.quantumsoftwaresolutions.quantumfinance.domain.User;

import java.util.List;
import java.util.Map;

public class UserFactory {
    public static User createUser(Map<String,String> values,
                                  List<Account> accounts,
                                  Cash cash) {
        User user = new User
                .Builder(values)
                .accounts(accounts)
                .cash(cash)
                .build();
        return user;
    }
}