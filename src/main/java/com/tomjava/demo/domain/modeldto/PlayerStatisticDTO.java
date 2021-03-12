package com.tomjava.demo.domain.modeldto;

import com.tomjava.demo.domain.Player;
import com.tomjava.demo.domain.PlayerAndTeam;
import com.tomjava.demo.domain.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PlayerStatisticDTO {

    private Long id;
    private Player player;
    private PlayerAndTeam playerAndTeam;
    private LocalDate startSeason;
    private LocalDate endSeason;
    private Integer goals;
    private Integer assists;
    private Integer points;
    private Integer plusMinus;
    private Integer goalsAgainst;
    private Integer shutouts;
    private Float saves;
}
