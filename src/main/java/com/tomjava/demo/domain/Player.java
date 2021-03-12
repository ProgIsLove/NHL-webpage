package com.tomjava.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "surname", length = 40, nullable = false)
    private String surname;

    @Column(name = "nationality", length = 5)
    private String nationality;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private Set<PlayerAndTeam> playerAndTeams = new HashSet<>();

    public Player addPlayerAndTeam(PlayerAndTeam playerAndTeam) {
        playerAndTeam.setPlayer(this);
        this.playerAndTeams.add(playerAndTeam);
        return this;
    }
}
