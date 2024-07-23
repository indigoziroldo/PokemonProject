package net.niantic.pokemon.application.domain.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.niantic.pokemon.application.domain.entities.TrainerEntity;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class TrainerDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String gender;

    public TrainerDTO(TrainerEntity trainerEntity) {
        this.id = trainerEntity.getId();
        this.firstName = trainerEntity.getFirstName();
        this.secondName = trainerEntity.getSecondName();
        this.email = trainerEntity.getEmail();
        this.password = trainerEntity.getPassword();
        this.gender = trainerEntity.getGender().getDescription();
    }

    public static List<TrainerDTO> convertToDTO(List<TrainerEntity> trainerEntity) {
        return trainerEntity.stream().map(TrainerDTO::new).collect(Collectors.toList());
    }
}
