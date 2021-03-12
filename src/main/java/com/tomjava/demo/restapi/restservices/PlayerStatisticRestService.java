package com.tomjava.demo.restapi.restservices;

import com.tomjava.demo.domain.PlayerStatistic;
import com.tomjava.demo.domain.modeldto.PlayerStatisticDTO;
import com.tomjava.demo.repositories.PlayerStatisticRepository;
import com.tomjava.demo.restapi.PlayerStatisticRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerStatisticRestService implements PlayerStatisticRest {

    private final PlayerStatisticRepository playerStatisticRepository;

    @Override
    public Set<PlayerStatisticDTO> findAll() {

        Set<PlayerStatistic> playerStatistics = new HashSet<>(playerStatisticRepository.findAll());

        return playerStatistics.stream().map(this::transformToDto).collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public PlayerStatisticDTO findById(Long aLong) {
        return null;
    }

    @Override
    public PlayerStatisticDTO createNewPlayerStat(PlayerStatisticDTO playerStatisticDTO){

        return saveAndReturnDTO(transformFromDTO(playerStatisticDTO));
    }

    @Override
    public PlayerStatisticDTO save(Long id, PlayerStatisticDTO playerStatisticDTO) {
        PlayerStatistic playerStatistic = this.transformFromDTO(playerStatisticDTO);
        playerStatistic.setId(id);

        return saveAndReturnDTO(playerStatistic);
    }

    private PlayerStatisticDTO saveAndReturnDTO(PlayerStatistic playerStatistic) {
        PlayerStatistic savedPlayerStat = playerStatisticRepository.save(playerStatistic);

        return transformToDto(savedPlayerStat);
    }

    private PlayerStatisticDTO transformToDto(PlayerStatistic playerStatistic) {
        PlayerStatisticDTO playerStatisticDTO = new PlayerStatisticDTO();
        playerStatisticDTO.setId(playerStatistic.getId());
        playerStatisticDTO.setStartSeason(playerStatistic.getStartSeason());
        playerStatisticDTO.setEndSeason(playerStatistic.getEndSeason());
        playerStatisticDTO.setGoals(playerStatistic.getGoals());
        playerStatisticDTO.setAssists(playerStatistic.getAssists());
        playerStatisticDTO.setPoints(playerStatistic.getPoints());
        playerStatisticDTO.setPlusMinus(playerStatistic.getPlusMinus());
        playerStatisticDTO.setGoalsAgainst(playerStatistic.getGoalsAgainst());
        playerStatisticDTO.setSaves(playerStatistic.getSaves());
        playerStatisticDTO.setShutouts(playerStatistic.getShutouts());
        playerStatisticDTO.setPlayer(playerStatistic.getPlayerAndTeam().getPlayer());
        playerStatisticDTO.setPlayerAndTeam(playerStatistic.getPlayerAndTeam());

        return playerStatisticDTO;
    }

    private PlayerStatistic transformFromDTO(PlayerStatisticDTO playerStatisticDTO){
        PlayerStatistic playerStatistic = new PlayerStatistic();
        playerStatistic.setId(playerStatisticDTO.getId());
        playerStatistic.setStartSeason(playerStatisticDTO.getStartSeason());
        playerStatistic.setEndSeason(playerStatisticDTO.getEndSeason());
        playerStatistic.setGoals(playerStatisticDTO.getGoals());
        playerStatistic.setAssists(playerStatisticDTO.getAssists());
        playerStatistic.setPoints(playerStatisticDTO.getPoints());
        playerStatistic.setPoints(playerStatisticDTO.getPoints());
        playerStatistic.setPlusMinus(playerStatisticDTO.getPlusMinus());
        playerStatistic.setGoalsAgainst(playerStatisticDTO.getGoalsAgainst());
        playerStatistic.setSaves(playerStatisticDTO.getSaves());
        playerStatistic.setShutouts(playerStatisticDTO.getShutouts());
        playerStatistic.setPlayerAndTeam(playerStatisticDTO.getPlayerAndTeam());

        return playerStatistic;
    }
}
