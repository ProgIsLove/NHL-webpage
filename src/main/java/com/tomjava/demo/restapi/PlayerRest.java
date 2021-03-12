package com.tomjava.demo.restapi;

import com.tomjava.demo.domain.modeldto.PlayerInfoDTO;

public interface PlayerRest extends CrudRestService<PlayerInfoDTO, Long> {

    PlayerInfoDTO createNewPlayer(PlayerInfoDTO playerInfoDTO);
}
