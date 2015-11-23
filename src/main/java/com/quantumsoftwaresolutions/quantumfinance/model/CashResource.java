package com.quantumsoftwaresolutions.quantumfinance.model;

import com.quantumsoftwaresolutions.quantumfinance.domain.Item;

import java.util.List;

public class CashResource {
    private long resid;

    private double balance;
    private List<Item> items;

    private CashResource() {
    }

    public long getResid() {
        return resid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Item> getItems() {
        return items;
    }

    public CashResource(Builder builder) {
        this.resid = builder.resid;
        this.balance = builder.balance;
        this.items = builder.items;
    }

    public static class Builder {
        private Long resid;
        private double balance;
        private List<Item> items;

        public Builder(double balance) {
            this.balance = balance;
        }

        public Builder resid(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder items(List<Item>  items) {
            this.items = items;
            return this;
        }

        public CashResource build() {
            return new CashResource(this);
        }
    }
}
