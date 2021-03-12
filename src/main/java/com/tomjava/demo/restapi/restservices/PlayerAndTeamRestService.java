package com.tomjava.demo.restapi.restservices;

import com.tomjava.demo.domain.PlayerAndTeam;
import com.tomjava.demo.domain.modeldto.PlayerAndTeamDTO;
import com.tomjava.demo.repositories.PlayerAndTeamRepository;
import com.tomjava.demo.restapi.PlayerAndTeamRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerAndTeamRestService implements PlayerAndTeamRest {

    private final PlayerAndTeamRepository playerAndTeamRepository;

    @Override
    public PlayerAndTeamDTO createNewPlayerAndTeam(PlayerAndTeamDTO playerAndTeamDTO){

        return saveAndReturnDTO(transformFromDTO(playerAndTeamDTO));
    }

    @Override
    public PlayerAndTeamDTO save(Long id, PlayerAndTeamDTO playerAndTeamDTO) {
        PlayerAndTeam playerAndTeam = this.transformFromDTO(playerAndTeamDTO);
        playerAndTeam.setId(id);

        return saveAndReturnDTO(playerAndTeam);
    }

    public PlayerAndTeamDTO saveAndReturnDTO(PlayerAndTeam playerAndTeam){
        PlayerAndTeam savedPlayerAndTeam = playerAndTeamRepository.save(playerAndTeam);

        return transformToDTO(savedPlayerAndTeam);
    }

    private PlayerAndTeamDTO transformToDTO(PlayerAndTeam playerAndTeam) {
        PlayerAndTeamDTO playerAndTeamDTO = new PlayerAndTeamDTO();
        playerAndTeamDTO.setId(playerAndTeam.getId());
        playerAndTeamDTO.setPlayerContractStart(playerAndTeam.getPlayerContractStart());
        playerAndTeamDTO.setPlayerContractEnd(playerAndTeam.getPlayerContractEnd());
        playerAndTeamDTO.setPlayer(playerAndTeam.getPlayer());
        playerAndTeamDTO.setTeam(playerAndTeam.getTeam());

        return playerAndTeamDTO;
    }

    private PlayerAndTeam transformFromDTO(PlayerAndTeamDTO playerAndTeamDTO){
        PlayerAndTeam playerAndTeam = new PlayerAndTeam();
        playerAndTeam.setId(playerAndTeamDTO.getId());
        playerAndTeam.setPlayerContractStart(playerAndTeamDTO.getPlayerContractStart());
        playerAndTeam.setPlayerContractEnd(playerAndTeamDTO.getPlayerContractEnd());
        playerAndTeam.setPlayer(playerAndTeamDTO.getPlayer());
        playerAndTeam.setTeam(playerAndTeamDTO.getTeam());

        return playerAndTeam;
    }
}
