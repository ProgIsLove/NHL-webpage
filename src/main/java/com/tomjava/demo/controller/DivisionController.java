package com.tomjava.demo.controller;

import com.tomjava.demo.services.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("nhl")
@Controller
@RequiredArgsConstructor
public class DivisionController {

    private final DivisionService divisionService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setAllowedFields("id");
    }

    @GetMapping("/division")
    public ModelAndView showDivision() {
        ModelAndView nav = new ModelAndView("/nhl/division/showdivision");
        nav.addObject("divisions", divisionService.findAll());
        return nav;
    }

    @GetMapping("/division/{divisionId}")
    public ModelAndView showById(@PathVariable("divisionId") Long divisionId) {
        ModelAndView nav = new ModelAndView("/nhl/division/divisionbyid");
        nav.addObject("division", divisionService.findById(divisionId));
        return nav;
    }
}
