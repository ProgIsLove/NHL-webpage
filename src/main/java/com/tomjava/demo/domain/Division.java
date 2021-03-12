package com.tomjava.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "division")
public class Division implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "division_name", nullable = false, length = 30)
    private String division;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private Set<Team> team = new HashSet<>();
}
