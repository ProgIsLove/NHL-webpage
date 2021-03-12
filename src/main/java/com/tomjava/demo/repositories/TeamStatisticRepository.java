package com.tomjava.demo.repositories;

import com.tomjava.demo.domain.TeamStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeamStatisticRepository extends JpaRepository<TeamStatistic, Long> {
}
