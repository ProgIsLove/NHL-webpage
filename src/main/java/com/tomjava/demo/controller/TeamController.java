package com.tomjava.demo.controller;

import com.tomjava.demo.domain.Division;
import com.tomjava.demo.domain.Team;
import com.tomjava.demo.services.DivisionService;
import com.tomjava.demo.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/nhl/division/{divisionId}")
@Controller
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final DivisionService divisionService;

    @ModelAttribute("division")
    public Division findDivision(@PathVariable Long divisionId) {
        return divisionService.findById(divisionId);
    }

    @InitBinder("division")
    public void initDivisionBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/{teamId}")
    public ModelAndView teamById(@PathVariable("teamId") Long teamId) {
        ModelAndView nav = new ModelAndView("nhl/team/showteam");
        nav.addObject("team", teamService.findById(teamId));
        return nav;
    }

    @GetMapping("/team/new")
    public String newTeam(Division division, Model model) {
        Team team = new Team();
        division.getTeam().add(team);
        team.setDivision(division);
        model.addAttribute("team", team);

        return "nhl/team/teamform";
    }

    @PostMapping("/team/new")
    public String saveOrUpdate(Division division, Team team) {
        division.getTeam().add(team);
        team.setDivision(division);
        teamService.save(team);

        return "redirect:/nhl/division/" + division.getId() + "/" + team.getId();
    }
}
