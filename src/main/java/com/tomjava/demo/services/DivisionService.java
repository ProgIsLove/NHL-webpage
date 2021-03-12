package com.tomjava.demo.services;

import com.tomjava.demo.domain.Division;

import java.util.Set;

public interface DivisionService {

    Set<Division> findAll();

    Division findById(Long id);

    Division save(Division object);
}
