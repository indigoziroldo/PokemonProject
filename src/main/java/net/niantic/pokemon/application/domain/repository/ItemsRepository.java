package net.niantic.pokemon.application.domain.repository;

import net.niantic.pokemon.application.domain.entities.ItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Long> {
}
