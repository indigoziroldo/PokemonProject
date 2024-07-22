package net.niantic.pokemon.application.domain.service;

import net.niantic.pokemon.application.domain.rest.dto.ItemsDTO;
import net.niantic.pokemon.application.domain.rest.forms.ItemsForm;

import java.util.List;

public interface ItemsService {

    void createItems(ItemsForm itemsForm);

    List<ItemsDTO> getAllItems();

    void updateItems(ItemsForm itemsForm, Long id);

    void deleteItems(Long id);
}
