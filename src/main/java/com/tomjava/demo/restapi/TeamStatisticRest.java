package com.tomjava.demo.restapi;

import com.tomjava.demo.domain.modeldto.TeamStatisticDTO;

import java.util.Set;

public interface TeamStatisticRest {

    Set<TeamStatisticDTO> findAll();
}
