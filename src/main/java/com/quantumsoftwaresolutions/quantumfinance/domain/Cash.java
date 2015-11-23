package com.quantumsoftwaresolutions.quantumfinance.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double balance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cash_item_id")
    private List<Item> items;

    private Cash() {
    }

    public long getId() {
        return id;
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

    public Cash(Builder builder) {
        this.id = builder.id;
        this.balance = builder.balance;
        this.items = builder.items;
    }

    public static class Builder {
        private Long id;
        private double balance;
        private List<Item> items;

        public Builder(double balance) {
            this.balance = balance;
        }

        public Builder id(Long id) {
            this.id = id;
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

        public Builder copy(Cash Cash) {
            this.id = Cash.getId();
            this.balance = Cash.getBalance();
            return this;
        }

        public Cash build() {
            return new Cash(this);
        }
    }
}
