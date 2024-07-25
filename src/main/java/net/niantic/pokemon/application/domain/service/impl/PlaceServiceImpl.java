package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;
import net.niantic.pokemon.application.domain.rest.forms.PlaceForm;
import net.niantic.pokemon.application.domain.service.PlaceService;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {
    @Override
    public void createPlace(PlaceForm placeForm) {

    }

    @Override
    public List<PlaceDTO> getAllPlaces() {
        return List.of();
    }

    @Override
    public void updatePlace(PlaceForm placeForm, Long id) {

    }

    @Override
    public void deletePlace(Long id) {

    }
}
