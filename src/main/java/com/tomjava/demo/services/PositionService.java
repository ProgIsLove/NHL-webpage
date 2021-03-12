package com.tomjava.demo.services;

import com.tomjava.demo.domain.Position;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Set;

public interface PositionService {

    Set<Position> listAllPosition(String position);
}
