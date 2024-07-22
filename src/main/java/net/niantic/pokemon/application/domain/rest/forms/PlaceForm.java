package net.niantic.pokemon.application.domain.rest.forms;

import net.niantic.pokemon.application.domain.entities.embbedable.City;
import net.niantic.pokemon.application.domain.entities.enums.Gym;
import lombok.Getter;

@Getter
public class PlaceForm {

    private Long id;
    private Gym gym;
    private City city;

}
