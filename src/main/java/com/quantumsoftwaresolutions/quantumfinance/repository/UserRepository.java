package com.quantumsoftwaresolutions.quantumfinance.repository;

import com.quantumsoftwaresolutions.quantumfinance.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
}
