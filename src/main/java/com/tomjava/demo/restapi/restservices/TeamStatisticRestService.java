package com.tomjava.demo.restapi.restservices;

import com.tomjava.demo.domain.Team;
import com.tomjava.demo.domain.TeamStatistic;
import com.tomjava.demo.domain.modeldto.TeamStatisticDTO;
import com.tomjava.demo.repositories.TeamStatisticRepository;
import com.tomjava.demo.restapi.TeamStatisticRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamStatisticRestService implements TeamStatisticRest {

    private final TeamStatisticRepository teamStatisticRepository;

    @Override
    public Set<TeamStatisticDTO> findAll() {

        Set<TeamStatistic> ts = new HashSet<>(teamStatisticRepository.findAll());

        return ts.stream().map(this::transformDto).collect(Collectors.toCollection(HashSet::new));
    }

    private TeamStatisticDTO transformDto(TeamStatistic teamStatistic) {
        TeamStatisticDTO teamStatDTO = new TeamStatisticDTO();
        teamStatDTO.setId(teamStatistic.getId());
        Team team = teamStatistic.getTeam();
        teamStatDTO.setTeamName(team.getTeamName());
        teamStatDTO.setWins(teamStatistic.getWins());
        teamStatDTO.setLosses(teamStatistic.getLosses());
        teamStatDTO.setTies(teamStatistic.getTies());
        teamStatDTO.setPoints(teamStatistic.getPoints());
        teamStatDTO.setPlayoff(teamStatistic.getPlayoff());
        teamStatDTO.setStartSeason(teamStatistic.getStartSeason());
        teamStatDTO.setEndSeason(teamStatistic.getEndSeason());

        return teamStatDTO;
    }
}
