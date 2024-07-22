package net.niantic.pokemon.application.domain.service;

import net.niantic.pokemon.application.domain.rest.dto.BattleDTO;
import net.niantic.pokemon.application.domain.rest.forms.BattleForm;

import java.util.List;

public interface BattleService {

    void createBattle (BattleForm battleForm);

    List<BattleDTO> getAllBattles();

    void updateBattle (BattleForm battleForm, Long id);

    void deleteBattle(Long id);
}
