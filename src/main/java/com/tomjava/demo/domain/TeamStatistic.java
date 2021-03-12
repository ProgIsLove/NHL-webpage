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
@Table(name = "team_statistic")
public class TeamStatistic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "wins")
    private int wins;

    @Column(name = "losses")
    private int losses;

    @Column(name = "OT_Shootoutlosses")
    private int ties;

    @Column(name = "points")
    private int points;

    @Column(name = "playoff", nullable = false)
    private String playoff;

    @Column(name = "season_start", nullable = false)
    private LocalDate startSeason;

    @Column(name = "season_end", nullable = false)
    private LocalDate endSeason;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
