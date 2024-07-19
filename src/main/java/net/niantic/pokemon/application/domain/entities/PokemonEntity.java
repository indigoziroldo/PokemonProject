package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.embbedable.PokemonId;
import net.niantic.pokemon.application.domain.entities.enums.Region;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemons", schema = "public")
public class PokemonEntity {

    @EmbeddedId
    private PokemonId id;

    @Column(name = "Hp")
    private BigDecimal hp;

    @Column(name = "Attack")
    private Long attack;

    @Column(name = "Defense")
    private Long defense;

    @Column(name = "Speed")
    private Long speed;

    @Column(name = "Region")
    private Region region;

}
