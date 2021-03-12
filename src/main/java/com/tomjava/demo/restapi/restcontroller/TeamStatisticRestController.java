package com.tomjava.demo.restapi.restcontroller;


import com.tomjava.demo.domain.modeldto.TeamStatisticDTO;
import com.tomjava.demo.restapi.TeamStatisticRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(TeamStatisticRestController.BASE_URL)
@RequiredArgsConstructor
public class TeamStatisticRestController {

    public static final String BASE_URL = "/api/nhl/teamstatistic";
    private final TeamStatisticRest teamStatisticRest;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Set<TeamStatisticDTO> getStatistic(){

        return new HashSet<>(teamStatisticRest.findAll());
    }
}
