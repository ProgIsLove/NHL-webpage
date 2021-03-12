package com.tomjava.demo.repositories;

import com.tomjava.demo.domain.PlayerAndTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerAndTeamRepository extends JpaRepository<PlayerAndTeam, Long> {
}
