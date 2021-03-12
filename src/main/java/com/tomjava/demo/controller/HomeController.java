package com.tomjava.demo.controller;

import com.tomjava.demo.services.TeamService;
import com.tomjava.demo.services.TeamStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TeamService teamService;
    private final TeamStatisticService teamStatisticService;

    @GetMapping("/nhl")
    public ModelAndView getHomePage() {
        ModelAndView nav = new ModelAndView("homepage");
        nav.addObject("teams", teamService.findAll());
        return nav;
    }

    @GetMapping("/nhl/teamstatistic")
    public ModelAndView showTeamStatistic() {
        ModelAndView nav = new ModelAndView("nhl/team/showteamstatistic");
        nav.addObject("teamstatistic", teamStatisticService.findAll());
        return nav;
    }
}
