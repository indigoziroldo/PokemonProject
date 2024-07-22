package net.niantic.pokemon.application.domain.entities.embbedable;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class City {

    private String name;
}
