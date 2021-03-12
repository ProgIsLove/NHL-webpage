package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.Division;
import com.tomjava.demo.repositories.DivisionRepository;
import com.tomjava.demo.services.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DivisionJpaService implements DivisionService {

    private final DivisionRepository divisionRepository;

    @Override
    public Set<Division> findAll() {
        Set<Division> divisions = new HashSet<>();

        divisionRepository.findAll().forEach(divisions::add);

        return divisions;
    }

    @Override
    @Transactional
    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Division save(Division object) {
        return divisionRepository.save(object);
    }
}
