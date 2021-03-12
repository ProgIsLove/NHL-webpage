package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.Position;
import com.tomjava.demo.repositories.PositionRepository;
import com.tomjava.demo.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class PositionJpaService implements PositionService {

    private PositionRepository positionRepository;

    @Override
    public Set<Position> listAllPosition(String position) {
        return StreamSupport.stream(positionRepository.findAll().spliterator(), false).collect(Collectors.toSet());
    }
}
