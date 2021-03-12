package com.tomjava.demo.bootstrap;

import com.tomjava.demo.domain.*;
import com.tomjava.demo.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class NhlBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final PositionRepository positionRepository;
    private final DivisionRepository divisionRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerAndTeamRepository playerAndTeamRepository;
    private final PlayerStatisticRepository playerStatisticRepository;
    private final TeamStatisticRepository teamStatisticRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        getNhlData();
    }

    private void getNhlData() {
        String[] positions = {"Center", "Right Wing", "Left Wing", "Defenseman", "Goalie"};
        String[] divisions = {"NORTH", "WEST", "CENTRAL", "EAST"};

        for (String position : positions) {
            Optional<Position> positionName = positionRepository.findByPosition(position);
            checkPosition(positionName);
        }

        for (String division : divisions) {
            Optional<Division> divisionName = divisionRepository.findByDivision(division);
            checkDivision(divisionName);
        }

        Optional<Position> centerPositionOptional = positionRepository.findByPosition("Center");
        checkPosition(centerPositionOptional);

        Optional<Division> eastDivisionOptional = divisionRepository.findByDivision("EAST");
        checkDivision(eastDivisionOptional);

        PlayerStatistic playerStat = new PlayerStatistic();
        playerStat.setGoals(41);
        playerStat.setAssists(54);
        playerStat.setPlusMinus(13);
        playerStat.setStartSeason(LocalDate.of(2018,9,3));
        playerStat.setEndSeason(LocalDate.of(2019,4,6));
        playerStat.setPoints(95);

        TeamStatistic teamStat = new TeamStatistic();
        teamStat.setStartSeason(LocalDate.of(2018, 9, 3));
        teamStat.setEndSeason(LocalDate.of(2019, 4, 6));
        teamStat.setLosses(26);
        teamStat.setWins(44);
        teamStat.setTies(12);
        teamStat.setPoints(100);
        teamStat.setPlayoff("ano");

        PlayerAndTeam pat = new PlayerAndTeam();
        pat.setPlayerContractStart(LocalDate.of(2005, 8, 28));
        pat.setPlayerContractEnd(LocalDate.of(2027, 8, 28));
        pat.addPlayerStat(playerStat);

        Player playerOne = new Player();
        playerOne.setName("Sidney");
        playerOne.setSurname("Crosby");
        playerOne.setNationality("CAN");
        playerOne.setPosition(centerPositionOptional.get());
        playerOne.addPlayerAndTeam(pat);

        Team teamOne = new Team();
        teamOne.setTeamName("Pittsburgh Penguins");
        teamOne.setDivision(eastDivisionOptional.get());
        teamOne.addStatistic(teamStat);
        teamOne.addPlayerAndTeam(pat);

        teamRepository.save(teamOne);
        teamStatisticRepository.save(teamStat);
        playerRepository.save(playerOne);
        playerAndTeamRepository.save(pat);
        playerStatisticRepository.save(playerStat);
    }

    private void checkPosition(Optional<Position> position) {
        if (position.isEmpty()) {
            log.error("Excepted POSITION Not found");
        }

    }

    private void checkDivision(Optional<Division> division) {
        if (division.isEmpty()) {
            log.error("Excepted DIVISION Not found");
        }
    }
}

