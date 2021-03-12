package com.tomjava.demo.restapi;

import com.tomjava.demo.domain.modeldto.TeamDTO;

import java.util.Set;

public interface TeamRest {

    Set<TeamDTO> findAll();
}
