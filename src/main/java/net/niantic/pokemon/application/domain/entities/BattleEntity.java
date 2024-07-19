package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Battle", schema = "public")
public class BattleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PlaceEntity place;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column(name = "captured_pokemon")
    private Long idcapturedPokemon;

    @OneToOne
    @JoinColumn(name = "captured_pokemon",updatable = false, insertable = false)
    private PokemonCapturedEntity capturedPokemon;

    @Column(name = "random_pokemon")
    private Long idrandomPokemon;

    @OneToOne
    @JoinColumn(name = "random_pokemon",updatable = false,insertable = false)
    private PokemonEntity randomPokemon;
}
