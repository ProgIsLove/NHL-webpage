package com.tomjava.demo.controller;

import com.tomjava.demo.services.PlayerStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/nhl")
@Controller
@RequiredArgsConstructor
public class PlayerStatisticController {

    private final PlayerStatisticService playerStatisticService;

    @GetMapping("/playerstatistic")
    public ModelAndView showPlayerStatistic() {
        ModelAndView nav = new ModelAndView("nhl/player/playerstatistic");
        nav.addObject("playerstatistic", playerStatisticService.findAll());
        return nav;
    }
}
