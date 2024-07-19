package net.niantic.pokemon.application.domain.rest.forms;

import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.ItemsEntity;
import net.niantic.pokemon.application.domain.rest.dto.ItemsDTO;

@Getter
public class BagForm {
    private Long id;
    private ItemsDTO itemsDTO;
    private String color;

}
