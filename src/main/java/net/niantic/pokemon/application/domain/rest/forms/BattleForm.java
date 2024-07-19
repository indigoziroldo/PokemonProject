package net.niantic.pokemon.application.domain.rest.forms;

import lombok.Getter;
import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;

@Getter
public class BattleForm {

    private Long id;
    private PlaceForm placeForm;
    private String startTime;
    private String endTime;
    private PokemonCapturedForm pokemonCapturedForm;
    private PokemonForm pokemonForm;

}
