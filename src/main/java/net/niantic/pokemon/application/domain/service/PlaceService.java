package net.niantic.pokemon.application.domain.service;

import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;
import net.niantic.pokemon.application.domain.rest.forms.PlaceForm;

import java.util.List;

public interface PlaceService {

    void createPlace (PlaceForm placeForm);

    List<PlaceDTO> getAllPlaces();

    void updatePlace (PlaceForm placeForm, Long id);

    void deletePlace (Long id);
}
