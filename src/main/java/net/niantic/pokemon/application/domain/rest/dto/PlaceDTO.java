package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.PlaceEntity;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDTO {

    private Long id;
    private String gym;
    private String city;

    public PlaceDTO(PlaceEntity placeEntity){
        this.id = placeEntity.getId();
        this.gym = placeEntity.getGym().getBadge();
        this.city = placeEntity.getCity().getName();
    }

}
