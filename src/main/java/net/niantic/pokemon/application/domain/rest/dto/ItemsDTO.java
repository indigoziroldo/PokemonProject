package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.ItemsEntity;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class ItemsDTO {

    private Long id;
    private String name;
    private String description;
    private String category;
    private TrainerDTO trainerDTO;

    public ItemsDTO(ItemsEntity itemsEntity) {
        this.id = itemsEntity.getId();
        this.name = itemsEntity.getName();
        this.description = itemsEntity.getDescription();
        this.category = itemsEntity.getCategory();
        this.trainerDTO = new TrainerDTO(itemsEntity.getTrainer());
    }

    public static List<ItemsDTO> convertToDTO(List<ItemsEntity> itemsEntities) {
        return itemsEntities
                .stream()
                .map(ItemsDTO::new)
                .collect(Collectors.toList());
    }
}
