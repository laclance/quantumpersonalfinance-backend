package com.quantumsoftwaresolutions.quantumfinance.service.impl;

import com.quantumsoftwaresolutions.quantumfinance.domain.User;
import com.quantumsoftwaresolutions.quantumfinance.repository.UserRepository;
import com.quantumsoftwaresolutions.quantumfinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        Iterable<User> users = repository.findAll();
        User userfound = null;
        for(User user : users) {
            if (user.getUsername().equals(username)){
                userfound = user;
            }
        }
        return userfound;
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(User entity) {
        repository.delete(entity);
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        Iterable<User> users = repository.findAll();
        for(User user : users) {
            allUsers.add(user);
        }
        return allUsers;
    }
}
