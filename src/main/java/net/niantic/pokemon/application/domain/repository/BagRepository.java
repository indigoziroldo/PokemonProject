package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.BagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<BagEntity, Long> {

}
