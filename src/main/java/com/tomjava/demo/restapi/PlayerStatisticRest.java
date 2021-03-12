package com.tomjava.demo.restapi;

import com.tomjava.demo.domain.modeldto.PlayerStatisticDTO;

public interface PlayerStatisticRest extends CrudRestService<PlayerStatisticDTO, Long>{

    PlayerStatisticDTO createNewPlayerStat(PlayerStatisticDTO playerStatisticDTO);
}
