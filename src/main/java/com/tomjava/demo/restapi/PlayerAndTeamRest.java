package com.tomjava.demo.restapi;

import com.tomjava.demo.domain.modeldto.PlayerAndTeamDTO;

public interface PlayerAndTeamRest {

    PlayerAndTeamDTO createNewPlayerAndTeam(PlayerAndTeamDTO playerAndTeamDTO);

    PlayerAndTeamDTO save(Long id, PlayerAndTeamDTO playerAndTeamDTO);
}
