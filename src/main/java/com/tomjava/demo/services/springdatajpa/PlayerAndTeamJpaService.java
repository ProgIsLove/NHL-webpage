package com.tomjava.demo.services.springdatajpa;

import com.tomjava.demo.domain.PlayerAndTeam;
import com.tomjava.demo.repositories.PlayerAndTeamRepository;
import com.tomjava.demo.services.PlayerAndTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class PlayerAndTeamJpaService implements PlayerAndTeamService {

    private final PlayerAndTeamRepository playerAndTeamRepository;

    @Override
    public Set<PlayerAndTeam> findAll() {

        Set<PlayerAndTeam> playerAndTeams = new HashSet<>();

        playerAndTeamRepository.findAll().forEach(playerAndTeams::add);

        return playerAndTeams;
    }

    @Override
    public PlayerAndTeam findById(Long id) {
        return playerAndTeamRepository.findById(id).orElse(null);
    }

    @Override
    public PlayerAndTeam save(PlayerAndTeam object) {
        return playerAndTeamRepository.save(object);
    }
}
