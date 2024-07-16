package net.niantic.pokemon.application.domain.entities;

import net.niantic.pokemon.application.domain.entities.enums.Gym;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "place")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String City;

    @Column
    private Gym Gym;

}
