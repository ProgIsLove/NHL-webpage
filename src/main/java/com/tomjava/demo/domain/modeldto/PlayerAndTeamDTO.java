package com.tomjava.demo.domain.modeldto;

import com.tomjava.demo.domain.Player;
import com.tomjava.demo.domain.Team;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PlayerAndTeamDTO implements Serializable {
    private Long id;
    private Player player;
    private Team team;
    private LocalDate playerContractStart;
    private LocalDate playerContractEnd;

}
