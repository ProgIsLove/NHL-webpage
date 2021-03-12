package com.tomjava.demo.domain.modeldto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeamStatisticDTO {

    private Long id;
    private String teamName;
    private int wins;
    private int losses;
    private int ties;
    private int points;
    private String playoff;
    private LocalDate startSeason;
    private LocalDate endSeason;
}
