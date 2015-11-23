package com.quantumsoftwaresolutions.quantumfinance.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acc_no;
    private String type;
    private double balance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_item_id")
    private List<Item> items;

    private Account() {
    }

    public long getId() {
        return id;
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

    public Account(Builder builder) {
        this.id = builder.id;
        this.acc_no = builder.acc_no;
        this.type = builder.type;
        this.balance = builder.balance;
        this.items = builder.items;
    }

    public static class Builder {
        private Long id;
        private String acc_no;
        private String type;
        private double balance;
        private List<Item> items;

        public Builder(String acc_no) {
            this.acc_no = acc_no;
        }

        public Builder id(Long id) {
            this.id = id;
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
            this.type = values.get("acc_type");
            return this;
        }

        public Builder items(List<Item>  items) {
            this.items = items;
            return this;
        }

        public Builder copy(Account Account) {
            this.id = Account.getId();
            this.acc_no = Account.getAcc_no();
            this.type = Account.getType();
            this.balance = Account.getBalance();
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
