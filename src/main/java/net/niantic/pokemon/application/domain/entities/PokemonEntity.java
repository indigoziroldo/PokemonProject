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
@Table(name = "POKEMON", schema = "public")
public class PokemonEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Embedded
   private Type type;

    @Column(name = "hp")
    private BigDecimal hp;

    @Column(name = "attack")
    private Long attack;

    @Column(name = "defense")
    private Long defense;

    @Column(name = "speed")
    private Long speed;

    @Column(name = "trainer_id")
    private Long trainerId;

    @ManyToOne
    @JoinColumn(name = "pokemon_id", nullable = false)
    private TrainerEntity trainer;

}
