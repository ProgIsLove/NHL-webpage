package com.tomjava.demo.repositories;

import com.tomjava.demo.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long> {

    Optional<Position> findByPosition(String positionName);
}
