package com.quantumsoftwaresolutions.quantumfinance.repository;

import com.quantumsoftwaresolutions.quantumfinance.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
