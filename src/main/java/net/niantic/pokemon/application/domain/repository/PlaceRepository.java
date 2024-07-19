package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository <PlaceEntity,Long> {
}
