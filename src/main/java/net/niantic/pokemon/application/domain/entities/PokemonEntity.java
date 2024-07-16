package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.embbedable.TypePokemonEmbbedable;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemon", schema = "atividade_pokemon")
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String type;

    @Column(name = "Total")
    private Long total;

    @Column(name = "Hp")
    private Long hp;

    @Column(name = "Attack")
    private Long attack;

    @Column(name = "Defense")
    private Long defense;

    @Column(name = "Speed")
    private Long speed;

    @Column(name = "Generation")
    private Long generation;

    @ManyToMany
    Set<CapturedPokemonEntity> capturedPokemons;

    @Embedded
    TypePokemonEmbbedable TypePokemon;
}
