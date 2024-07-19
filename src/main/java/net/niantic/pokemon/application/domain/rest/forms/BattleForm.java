package net.niantic.pokemon.application.domain.rest.forms;

import lombok.Getter;
import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;

@Getter
public class BattleForm {

    private Long id;
    private PlaceDTO placeDTO;

}
