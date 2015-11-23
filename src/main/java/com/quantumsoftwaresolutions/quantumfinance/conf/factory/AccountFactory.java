package com.quantumsoftwaresolutions.quantumfinance.conf.factory;

import com.quantumsoftwaresolutions.quantumfinance.domain.Account;
import com.quantumsoftwaresolutions.quantumfinance.domain.Item;

import java.util.List;
import java.util.Map;

public class AccountFactory {
    public static Account createAccount(Map<String,String> values,
                                     double balance,
                                     List<Item> items) {
        Account account = new Account
                .Builder(values)
                .items(items)
                .build();
        return account;
    }
}
