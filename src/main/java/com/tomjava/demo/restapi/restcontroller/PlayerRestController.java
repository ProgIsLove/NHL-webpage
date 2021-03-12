package com.tomjava.demo.restapi.restcontroller;


import com.tomjava.demo.domain.modeldto.PlayerInfoDTO;
import com.tomjava.demo.restapi.PlayerRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(PlayerRestController.BASE_URL)
@RequiredArgsConstructor
public class PlayerRestController {

    public static final String BASE_URL = "/api/nhl";
    private final PlayerRest playerRest;

    @GetMapping("/players/list")
    @ResponseStatus(HttpStatus.OK)
    public Set<PlayerInfoDTO> getPlayers() {

        return new HashSet<>(playerRest.findAll());
    }

    @GetMapping("/player/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerInfoDTO getPlayerById(@PathVariable("id") Long id) {

        return playerRest.findById(id);
    }

    @PostMapping("/player/new")
    @ResponseStatus(HttpStatus.OK)
    public PlayerInfoDTO createNewPlayer(@RequestBody PlayerInfoDTO playerInfoDTO) {

        return playerRest.createNewPlayer(playerInfoDTO);
    }

    @PutMapping("/player/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public PlayerInfoDTO updatePlayer(@PathVariable("id") Long id, @RequestBody PlayerInfoDTO playerInfoDTO) {

        return playerRest.save(id, playerInfoDTO);
    }
}
