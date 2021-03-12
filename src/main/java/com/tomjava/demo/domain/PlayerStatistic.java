package com.tomjava.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "players_statistic")
public class PlayerStatistic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "goals")
    private Integer goals;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "points")
    private Integer points;

    @Column(name = "plus_minus")
    private Integer plusMinus;

    @Column(name = "goals_against")
    private Integer goalsAgainst;

    @Column(name = "shutouts")
    private Integer shutouts;

    @Column(name = "saves")
    private Float saves;

    @Column(name = "season_start")
    private LocalDate startSeason;

    @Column(name = "season_end")
    private LocalDate endSeason;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "player_and_team_id")
    private PlayerAndTeam playerAndTeam;

}
