package com.tomjava.demo.restapi.restservices;

import com.tomjava.demo.domain.Player;
import com.tomjava.demo.domain.modeldto.PlayerInfoDTO;
import com.tomjava.demo.repositories.PlayerRepository;
import com.tomjava.demo.restapi.PlayerRest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerRestService implements PlayerRest {

    private final PlayerRepository playerRepository;

    @Override
    public Set<PlayerInfoDTO> findAll() {

        Set<Player> players = new HashSet<>(playerRepository.findAll());

        return players.stream().map(player -> {
            PlayerInfoDTO playerInfoDTO = this.transformToDTO(player);
            playerInfoDTO.setPlayerUrl(getPlayerUrl(player.getId()));

            return playerInfoDTO;
        }).collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public PlayerInfoDTO findById(Long id) {

        return playerRepository.findById(id).map(this::transformToDTO).map(playerInfoDTO -> {
            playerInfoDTO.setPlayerUrl(getPlayerUrl(id));

            return playerInfoDTO;
        }).orElseThrow(NullPointerException::new);
    }

    @Override
    public PlayerInfoDTO save(Long id, PlayerInfoDTO playerInfoDTO) {
        Player player = this.transformFromDTO(playerInfoDTO);
        player.setId(id);

        return saveAndReturnDTO(player);
    }

    @Override
    public PlayerInfoDTO createNewPlayer(PlayerInfoDTO playerInfoDTO) {

        return saveAndReturnDTO(transformFromDTO(playerInfoDTO));
    }

    private PlayerInfoDTO saveAndReturnDTO(Player player) {
        Player savedPlayer = playerRepository.save(player);

        PlayerInfoDTO playerInfoDTO = transformToDTO(savedPlayer);

        playerInfoDTO.setPlayerUrl(getPlayerUrl(playerInfoDTO.getId()));

        return playerInfoDTO;
    }

    private String getPlayerUrl(Long id) {

        return "/player/" + id;
    }

    private PlayerInfoDTO transformToDTO(Player player) {
        PlayerInfoDTO playerInfoDTO = new PlayerInfoDTO();
        playerInfoDTO.setId(player.getId());
        playerInfoDTO.setName(player.getName());
        playerInfoDTO.setSurname(player.getSurname());
        playerInfoDTO.setNationality(player.getNationality());
        playerInfoDTO.setPosition(player.getPosition());

        return playerInfoDTO;
    }

    private Player transformFromDTO(PlayerInfoDTO playerInfoDTO) {
        Player player = new Player();
        player.setId(playerInfoDTO.getId());
        player.setName(playerInfoDTO.getName());
        player.setSurname(playerInfoDTO.getSurname());
        player.setNationality(playerInfoDTO.getNationality());
        player.setPosition(playerInfoDTO.getPosition());

        return player;
    }
}
