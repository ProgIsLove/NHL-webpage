package com.tomjava.demo.restapi.restcontroller;

import com.tomjava.demo.domain.modeldto.PlayerAndTeamDTO;
import com.tomjava.demo.restapi.PlayerAndTeamRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PlayerAndTeamRestController.BASE_URL)
@RequiredArgsConstructor
public class PlayerAndTeamRestController {

    public static final String BASE_URL = "/api/nhl/playerandteam";
    private final PlayerAndTeamRest playerAndTeamRest;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public PlayerAndTeamDTO createNewPlayerAndTeam(@RequestBody PlayerAndTeamDTO playerAndTeamDTO) {

        return playerAndTeamRest.createNewPlayerAndTeam(playerAndTeamDTO);
    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public PlayerAndTeamDTO updatePlayerAndTeam(@PathVariable("id") Long id, @RequestBody PlayerAndTeamDTO playerAndTeamDTO) {

        return playerAndTeamRest.save(id, playerAndTeamDTO);
    }
}
