package net.niantic.pokemon.application.domain.entities;

import net.niantic.pokemon.application.domain.entities.embbedable.City;
import net.niantic.pokemon.application.domain.entities.enums.Gym;
import net.niantic.pokemon.application.domain.entities.enums.Region;
import net.niantic.pokemon.application.domain.entities.embbedable.City;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PLACE", schema = "public")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Region region;

    @Column
    private Gym Gym;

    @EmbeddedId
    private City city;

}
