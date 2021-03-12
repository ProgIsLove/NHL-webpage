package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.Team;
import com.tomjava.demo.repositories.TeamRepository;
import com.tomjava.demo.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamJpaService implements TeamService {

    private final TeamRepository teamRepository;


    @Override
    public Set<Team> findAll() {

        Set<Team> teams = new HashSet<>();

        teamRepository.findAll().forEach(teams::add);

        return teams;
    }

    @Override
    public Team findById(Long id) {

        return teamRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Team save(Team object) {

        return teamRepository.save(object);
    }
}
