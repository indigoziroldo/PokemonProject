package net.niantic.pokemon.application.domain.entities.embbedable;

import jakarta.persistence.Embeddable;
import lombok.*;
import net.niantic.pokemon.application.domain.entities.enums.Type;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PokemonId {

    private String name;
    private Type type;

}
