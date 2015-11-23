package com.quantumsoftwaresolutions.quantumfinance.service;

import java.util.List;

public interface Service<S, ID> {

    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}
