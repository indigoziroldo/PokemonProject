package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.BattleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BattleRepository extends JpaRepository<BattleEntity, Long> {
    Optional<BattleEntity> findTrainersById(Long id);
}
