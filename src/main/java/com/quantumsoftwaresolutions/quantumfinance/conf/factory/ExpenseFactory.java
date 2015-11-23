package com.quantumsoftwaresolutions.quantumfinance.conf.factory;

import com.quantumsoftwaresolutions.quantumfinance.domain.Expense;
import com.quantumsoftwaresolutions.quantumfinance.domain.Item;

import java.util.Map;

public class ExpenseFactory {
    public static Item createExpense (Map<String, String> values,
                                  double amount) {
        Item item = new Expense
                .Builder(values)
                .amount(amount)
                .build();

        return item;
    }
}
