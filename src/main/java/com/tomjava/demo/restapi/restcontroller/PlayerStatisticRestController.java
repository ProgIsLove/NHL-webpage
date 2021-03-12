package com.tomjava.demo.restapi.restcontroller;


import com.tomjava.demo.domain.modeldto.PlayerStatisticDTO;
import com.tomjava.demo.restapi.PlayerStatisticRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(PlayerStatisticRestController.BASE_URL)
@RequiredArgsConstructor
public class PlayerStatisticRestController {

    public static final String BASE_URL = "/api/nhl/playerstatistic";
    private final PlayerStatisticRest playerStatisticRest;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Set<PlayerStatisticDTO> getPlayerStatistic() {

        return new HashSet<>(playerStatisticRest.findAll());
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PlayerStatisticDTO createNewPlayerStat(@RequestBody PlayerStatisticDTO playerStatisticDTO) {

        return playerStatisticRest.createNewPlayerStat(playerStatisticDTO);
    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public PlayerStatisticDTO updatePlayerStat(@PathVariable("id") Long id, @RequestBody PlayerStatisticDTO playerStatisticDTO) {

        return playerStatisticRest.save(id, playerStatisticDTO);
    }
}
