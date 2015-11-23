package com.quantumsoftwaresolutions.quantumfinance.repository;

import com.quantumsoftwaresolutions.quantumfinance.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
}
