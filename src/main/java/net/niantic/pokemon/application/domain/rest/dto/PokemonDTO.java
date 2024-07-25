package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.PokemonEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PokemonDTO {

    private Long id;
    private String name;
    private String type;
    private BigDecimal hp;
    private Long attack;
    private Long defense;
    private Long speed;
    private Long trainerId;

    public PokemonDTO(PokemonEntity pokemonEntity) {
        this.id = pokemonEntity.getId();
        this.name = pokemonEntity.getName();
        this.type = pokemonEntity.getType().getDescription();
        this.hp = pokemonEntity.getHp();
        this.attack = pokemonEntity.getAttack();
        this.defense = pokemonEntity.getDefense();
        this.speed = pokemonEntity.getSpeed();
        this.trainerId = pokemonEntity.getTrainerId();
    }

    public static List<PokemonDTO> convertToDTO(List<PokemonEntity> pokemonEntity) {
        return pokemonEntity.stream().map(PokemonDTO::new).collect(Collectors.toList());
    }

}
