package com.tomjava.demo.restapi.restservices;

import com.tomjava.demo.domain.Division;
import com.tomjava.demo.domain.Team;
import com.tomjava.demo.domain.modeldto.TeamDTO;
import com.tomjava.demo.repositories.TeamRepository;
import com.tomjava.demo.restapi.TeamRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamRestService implements TeamRest {

    private final TeamRepository teamRepository;

    @Override
    public Set<TeamDTO> findAll() {

        Set<Team> div = new HashSet<>(teamRepository.findAll());

        return div.stream().map(this::transformDto).collect(Collectors.toCollection(HashSet::new));
    }

    private TeamDTO transformDto(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        Division div = team.getDivision();
        teamDTO.setDivison(div.getDivision());
        teamDTO.setTeamName(team.getTeamName());

        return teamDTO;
    }
}
