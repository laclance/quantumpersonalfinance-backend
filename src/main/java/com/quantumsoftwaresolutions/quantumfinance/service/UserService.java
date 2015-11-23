package com.quantumsoftwaresolutions.quantumfinance.service;

import com.quantumsoftwaresolutions.quantumfinance.domain.User;

public interface UserService extends Service<User,Long> {
    public User findByUsername(String username);
}
