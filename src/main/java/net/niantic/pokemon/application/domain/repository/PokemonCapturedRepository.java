package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.PokemonCapturedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonCapturedRepository extends JpaRepository <PokemonCapturedEntity, Long> {
}
