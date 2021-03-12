package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.PlayerStatistic;
import com.tomjava.demo.repositories.PlayerStatisticRepository;
import com.tomjava.demo.services.PlayerStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayerStatisticJpaService implements PlayerStatisticService {

    private final PlayerStatisticRepository playerStatisticRepository;

    @Override
    public Set<PlayerStatistic> findAll() {
        Set<PlayerStatistic> playerStatistic = new HashSet<>();

        playerStatisticRepository.findAll().forEach(playerStatistic::add);

        return playerStatistic;
    }

    @Override
    public PlayerStatistic findById(Long id) {
        return null;
    }

    @Override
    public PlayerStatistic save(PlayerStatistic object) {
        return playerStatisticRepository.save(object);
    }

}
