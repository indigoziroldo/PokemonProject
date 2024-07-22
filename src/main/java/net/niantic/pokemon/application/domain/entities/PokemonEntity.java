package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.enums.Region;
import net.niantic.pokemon.application.domain.entities.enums.Type;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemons", schema = "public")
public class PokemonEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "type")
   private Type type;

    @Column(name = "Hp")
    private BigDecimal hp;

    @Column(name = "Attack")
    private Long attack;

    @Column(name = "Defense")
    private Long defense;

    @Column(name = "Speed")
    private Long speed;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private TrainerEntity trainer;

}
