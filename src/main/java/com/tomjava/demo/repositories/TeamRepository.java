package com.tomjava.demo.repositories;

import com.tomjava.demo.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
