package com.tomjava.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "player_and_team")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PlayerAndTeam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name = "player_contract_start", nullable = false)
    private LocalDate playerContractStart;

    @Column(name = "player_contract_end", nullable = false)
    private LocalDate playerContractEnd;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;

    @JsonIgnore
    @OneToMany(mappedBy = "playerAndTeam", cascade = CascadeType.ALL)
    private Set<PlayerStatistic> playerStatistics = new HashSet<>();

    public PlayerAndTeam addPlayerStat(PlayerStatistic playerStatistic) {
        playerStatistic.setPlayerAndTeam(this);
        this.playerStatistics.add(playerStatistic);
        return this;
    }
}
