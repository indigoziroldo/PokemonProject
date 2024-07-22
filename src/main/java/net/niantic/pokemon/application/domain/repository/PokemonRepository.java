package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository <PokemonEntity, PokemonId> {
}
