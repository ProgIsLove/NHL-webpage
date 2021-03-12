package com.tomjava.demo.repositories;

import com.tomjava.demo.domain.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DivisionRepository extends JpaRepository<Division, Long> {

   Optional<Division> findByDivision(String division);
}
