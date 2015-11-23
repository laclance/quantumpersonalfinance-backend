package com.quantumsoftwaresolutions.quantumfinance.conf.factory;

import com.quantumsoftwaresolutions.quantumfinance.domain.Income;
import com.quantumsoftwaresolutions.quantumfinance.domain.Item;

import java.util.Map;

public class IncomeFactory {
    public static Item createIncome(Map<String, String> values,
                                  double amount) {
        Item item = new Income
                .Builder(values)
                .amount(amount)
                .build();

        return item;
    }
}
