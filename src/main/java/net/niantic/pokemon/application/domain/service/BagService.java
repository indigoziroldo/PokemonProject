package net.niantic.pokemon.application.domain.service;

import net.niantic.pokemon.application.domain.rest.dto.BagDTO;
import net.niantic.pokemon.application.domain.rest.forms.BagForm;

import java.util.List;

public interface BagService {

    void createBag (BagForm bagForm);

    List<BagDTO> getAllBags();

    void updateBag (BagForm bagForm, Long id);

    void deleteBag (Long id);
}
