package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.Player;
import com.tomjava.demo.repositories.PlayerRepository;
import com.tomjava.demo.services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayerJpaService implements PlayerService {

    public PlayerRepository playerRepository;

    @Override
    public Set<Player> findAll() {

        Set<Player> players = new HashSet<>();

        playerRepository.findAll().forEach(players::add);

        return players;
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public Player save(Player object) {
        return playerRepository.save(object);
    }
}
