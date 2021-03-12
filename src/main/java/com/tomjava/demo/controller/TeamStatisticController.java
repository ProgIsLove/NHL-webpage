package com.tomjava.demo.controller;

import com.tomjava.demo.domain.Team;
import com.tomjava.demo.domain.TeamStatistic;
import com.tomjava.demo.services.TeamService;
import com.tomjava.demo.services.TeamStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@RequestMapping("/nhl")
@Controller
@RequiredArgsConstructor
public class TeamStatisticController {

    private final TeamStatisticService teamStatisticService;
    private final TeamService teamService;

    @InitBinder
    public void initTeamBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("teamstat")
    public TeamStatistic loadTeamWithStat(@PathVariable Long teamId, Map<String, Object> model) {
        Team team = teamService.findById(teamId);
        model.put("team", team);
        TeamStatistic teamStatistic = new TeamStatistic();
        team.getTeamStatistic().add(teamStatistic);
        teamStatistic.setTeam(team);
        return teamStatistic;
    }

    @GetMapping("/division/*/{teamId}/teamstatistic/new")
    public String newTeamStatistic(@PathVariable Long teamId, Map<String, Object> model) {
        return "nhl/team/createteamstatform";
    }

    @PostMapping("/division/{divisionId}/{teamId}/teamstatistic/new")
    public String saveTeamStatistic(Team team, TeamStatistic teamStatistic) {
        team.addStatistic(teamStatistic);
        teamStatistic.setTeam(team);
        teamStatisticService.save(teamStatistic);
        return "redirect:/nhl";
    }
}
