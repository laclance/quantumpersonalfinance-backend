package com.quantumsoftwaresolutions.quantumfinance.conf.factory;

import com.quantumsoftwaresolutions.quantumfinance.domain.Cash;
import com.quantumsoftwaresolutions.quantumfinance.domain.Item;

import java.util.List;

public class CashFactory {
    public static Cash createCash(double balance, List<Item> items) {
        Cash cash = new Cash
                .Builder(balance)
                .items(items)
                .build();
        return cash;
    }
}
