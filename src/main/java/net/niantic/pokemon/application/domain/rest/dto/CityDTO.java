package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.embbedable.City;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    private String name;

    public CityDTO(City city) {
        this.name = city.getName();
    }
    public static List<CityDTO> convertToDTO(List<City> cities) {
        return cities
                .stream()
                .map(CityDTO::new)
                .collect(Collectors.toList());
    }
}
