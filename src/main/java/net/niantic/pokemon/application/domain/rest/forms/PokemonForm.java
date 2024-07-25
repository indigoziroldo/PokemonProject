package net.niantic.pokemon.application.domain.rest.forms;

import java.math.BigDecimal;
import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.enums.Type;

@Getter
public class PokemonForm {

    private String id;
    private String name;
    private BigDecimal hp;
    private Long attack;
    private Long defense;
    private Long speed;
    private String type;
    private Long trainerId;

}
