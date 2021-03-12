package com.tomjava.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "team_name", length = 80, nullable = false)
    private String teamName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "team")
    private Set<TeamStatistic> teamStatistic = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private Set<PlayerAndTeam> playerAndTeams = new HashSet<>();

    public Team addStatistic(TeamStatistic teamStatistic) {
        teamStatistic.setTeam(this);
        this.teamStatistic.add(teamStatistic);
        return this;
    }

    public Team addPlayerAndTeam(PlayerAndTeam playerAndTeam) {
        playerAndTeam.setTeam(this);
        this.playerAndTeams.add(playerAndTeam);
        return this;
    }
}
