package net.niantic.pokemon.application.domain.entities;

import net.niantic.pokemon.application.domain.entities.enums.Gym;
import net.niantic.pokemon.application.domain.entities.enums.Region;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
@Table(name = "gym", schema = "public")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Gym Gym;

    @Column
    private String City;


}
