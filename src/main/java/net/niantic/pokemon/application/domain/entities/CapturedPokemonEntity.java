package net.niantic.pokemon.application.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "capturedPokemon")
public class CapturedPokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private Long idPokemon;

    @ManyToMany
    Set <PokemonEntity> stats;

    @Column
    private Long idPlace;

    @ManyToOne
    @JoinColumn
    private PlaceEntity place;



}
