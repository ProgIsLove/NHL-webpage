package com.tomjava.demo.domain.modeldto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tomjava.demo.domain.Position;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlayerInfoDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String nationality;
    private Position position;

    @JsonProperty("player_url")
    private String playerUrl;
}
