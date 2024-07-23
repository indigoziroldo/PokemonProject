package net.niantic.pokemon.application.domain.service.impl;

import net.niantic.pokemon.application.domain.repository.BattleRepository;
import org.springframework.stereotype.Service;

@Service
public class BattleServiceImpl {

    private final BattleRepository battleRepository;

    public BattleServiceImpl(BattleRepository battleRepository) {
        this.battleRepository = battleRepository;
    }


}
