package com.quantumsoftwaresolutions.quantumfinance.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private List<Account> accounts;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cash_id")
    private Cash cash;

    private User() {}

    public Long getId() {
        return id;
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

    public User(Builder builder) {
        id = builder.id;
        username = builder.username;
        password = builder.password;
        accounts = builder.accounts;
        cash = builder.cash;
    }

    public static class Builder {
        private Long id;
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

        public Builder id(Long id) {
            this.id = id;
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

        public Builder copy(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.accounts = user.getAccounts();
            this.cash = user.getCash();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
