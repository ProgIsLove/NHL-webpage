package com.tomjava.demo.repositories;

import com.tomjava.demo.domain.PlayerStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatisticRepository extends JpaRepository<PlayerStatistic, Long> {
}
