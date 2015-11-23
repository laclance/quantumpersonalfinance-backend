package com.quantumsoftwaresolutions.quantumfinance.model;

import com.quantumsoftwaresolutions.quantumfinance.domain.Item;

import java.util.List;
import java.util.Map;

public class AccountResource {
    private long resid;

    private String acc_no;
    private String type;
    private double balance;
    private List<Item> items;

    private AccountResource() {
    }

    public long getResid() {
        return resid;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public AccountResource(Builder builder) {
        this.resid = builder.resid;
        this.acc_no = builder.acc_no;
        this.type = builder.type;
        this.balance = builder.balance;
        this.items = builder.items;
    }

    public static class Builder {
        private Long resid;
        private String acc_no;
        private String type;
        private double balance;
        private List<Item> items;

        public Builder(String acc_no) {
            this.acc_no = acc_no;
        }

        public Builder resid(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder(Map<String,String> values) {
            this.acc_no = values.get("acc_no");
            this.type = values.get("type");
        }

        public Builder acc_no(String acc_no) {
            this.acc_no = acc_no;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder values (Map<String,String> values) {
            this.acc_no = values.get("acc_no");
            this.type = values.get("type");
            return this;
        }

        public Builder items(List<Item>  items) {
            this.items = items;
            return this;
        }

        public AccountResource build() {
            return new AccountResource(this);
        }
    }
}
