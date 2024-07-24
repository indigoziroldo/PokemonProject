package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.BattleEntity;
import net.niantic.pokemon.application.domain.entities.PokemonEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {

    List<TrainerEntity> findAllByPokemon(PokemonEntity pokemon);

    List<TrainerEntity> findAllByBattle(BattleEntity battleEntity);
}
