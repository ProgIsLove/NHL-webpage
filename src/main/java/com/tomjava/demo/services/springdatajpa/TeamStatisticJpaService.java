package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.TeamStatistic;
import com.tomjava.demo.repositories.TeamStatisticRepository;
import com.tomjava.demo.services.TeamStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamStatisticJpaService implements TeamStatisticService {

    private final TeamStatisticRepository teamStatisticRepository;

    @Override
    public Set<TeamStatistic> findAll() {
        Set<TeamStatistic> statistic = new HashSet<>();

        teamStatisticRepository.findAll().forEach(statistic::add);

        return statistic;
    }

    @Override
    public TeamStatistic findById(Long aLong) {
        return null;
    }

    @Override
    @Transactional
    public TeamStatistic save(TeamStatistic object) {
        return teamStatisticRepository.save(object);
    }
}
