package net.niantic.pokemon.application.domain.entities.embbedable;

import jakarta.persistence.Embeddable;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.enums.Type;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PokemonId implements Serializable {

    private String name;
    private Type type;

}
