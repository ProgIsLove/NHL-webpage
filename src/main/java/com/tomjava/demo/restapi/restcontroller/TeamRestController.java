package com.tomjava.demo.restapi.restcontroller;

import com.tomjava.demo.domain.modeldto.TeamDTO;
import com.tomjava.demo.restapi.TeamRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(TeamRestController.BASE_URL)
@RequiredArgsConstructor
public class TeamRestController {

    public static final String BASE_URL = "/api/nhl/team";
    private final TeamRest teamRest;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Set<TeamDTO> getTeamByDivision() {

        return new HashSet<>(teamRest.findAll());
    }
}
