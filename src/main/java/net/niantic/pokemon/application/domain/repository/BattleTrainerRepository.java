package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.BattleTrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleTrainerRepository extends JpaRepository<BattleTrainerEntity, Long> {
}
