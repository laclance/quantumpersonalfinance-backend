package com.quantumsoftwaresolutions.quantumfinance.model;

import com.quantumsoftwaresolutions.quantumfinance.domain.Account;
import com.quantumsoftwaresolutions.quantumfinance.domain.Cash;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class UserResource {
    private Long resid;
    private String username;
    private String password;
    private List<Account> accounts;
    private Cash cash;

    private UserResource() {}

    public Long getResid() {
        return resid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Cash getCash() {
        return cash;
    }

    public UserResource(Builder builder) {
        resid = builder.resid;
        username = builder.username;
        password = builder.password;
        accounts = builder.accounts;
        cash = builder.cash;
    }

    public static class Builder {
        private Long resid;
        private String username;
        private String password;
        private List<Account> accounts;
        private Cash cash;

        public Builder() {
        }

        public Builder(Map<String,String> values) {
            this.username = values.get("username");
            this.password = values.get("password");
        }

        public Builder resid(Long resid) {
            this.resid = resid;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder accounts(List<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public Builder cash(Cash cash) {
            this.cash = cash;
            return this;
        }

        public Builder values (Map<String,String> values) {
            this.username = values.get("username");
            this.password = values.get("password");
            return this;
        }


        public UserResource build() {
            return new UserResource(this);
        }
    }
}
