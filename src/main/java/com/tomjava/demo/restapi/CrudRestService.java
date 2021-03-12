package com.tomjava.demo.restapi;

import java.util.Set;

public interface CrudRestService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(ID id, T object);
}
