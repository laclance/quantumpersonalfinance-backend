package com.quantumsoftwaresolutions.quantumfinance.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private String type;
    private String date;
    private String frequency;
    private double amount;

    private Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Item(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.date = builder.date;
        this.frequency = builder.frequency;
        this.amount = builder.amount;
    }

    public static class Builder {
        private Long id;
        private String type;
        private String date;
        private String frequency;
        private double amount;

        public Builder(Map<String, String> values) {
            this.type = values.get("type");
            this.date = values.get("date");
            this.frequency = values.get("frequency");
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder frequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder copy(Item item) {
            this.id = item.getId();
            this.type = item.getType();
            this.date = item.getDate();
            this.frequency = item.getFrequency();
            this.amount = item.getAmount();
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}

