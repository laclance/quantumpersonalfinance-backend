package com.quantumsoftwaresolutions.quantumfinance.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.Map;

public class ItemResource extends ResourceSupport {
    private Long resid;
    
    private String type;
    private String date;
    private String frequency;
    private double amount;

    private ItemResource() {
    }

    public long getResid() {
        return resid;
    }

    public void setResid(long resid) {
        this.resid = resid;
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

    public ItemResource(Builder builder) {
        this.resid = builder.resid;
        this.type = builder.type;
        this.date = builder.date;
        this.frequency = builder.frequency;
        this.amount = builder.amount;
    }

    public static class Builder {
        private Long resid;
        private String type;
        private String date;
        private String frequency;
        private double amount;

        public Builder(Map<String, String> values) {
            this.type = values.get("type");
            this.date = values.get("date");
            this.frequency = values.get("frequency");
        }

        public Builder resid(Long resid) {
            this.resid = resid;
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

        public ItemResource build() {
            return new ItemResource(this);
        }
    }
}
