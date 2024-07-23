package net.niantic.pokemon.application.domain.rest.forms;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;

@Getter
public class BattleForm {

    private Long id;
    @Size(min = 1, max = 50)
    private PlaceForm placeForm;
    private String startTime;
    private String endTime;
    private PokemonForm pokemonForm;

}
