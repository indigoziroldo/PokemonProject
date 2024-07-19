package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.BattleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<BattleEntity, Long> {
}
