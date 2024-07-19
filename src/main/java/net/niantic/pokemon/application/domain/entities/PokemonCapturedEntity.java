package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemonCaptured", schema = "public")
public class PokemonCapturedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "captured_date")
    private LocalDate capturedAt;

    @Column(name = "id_pokemon")
    private Long idPokemon;

    @ManyToOne
    @JoinColumn(name = "id_pokemon", updatable = false, insertable = false)
    private PokemonEntity pokemon;

    @Column(name = "trainer")
    private Long idTrainer;

    @OneToOne
    @JoinColumn(name = "trainer", updatable = false, insertable = false)
    private UserEntity trainer;

}
