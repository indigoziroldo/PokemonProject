package net.niantic.pokemon.application.domain.rest.forms;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class PokemonForm {

    private String id;
    private BigDecimal hp;
    private Long attack;
    private Long defense;
    private Long speed;
    private String region;

}
