package net.niantic.pokemon.application.domain.rest.forms;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;

import java.util.List;

@Getter
public class BattleForm {

    @PastOrPresent
    @Size(min = 19, max = 22, message = "Start time must be between 19 and 22 characters")
    private String startTime;

    @PastOrPresent
    @Size(min = 19, max = 22, message = "Start time must be between 19 and 22 characters")
    private String endTime;

    @NotNull(message = "Place_ID cannot be null")
    private Long placeId;

    @NotNull(message = "Trainer_1_ID cannot be null")
    private Long trainer1Id;

    @NotNull(message = "Trainer_2_ID cannot be null")
    private Long trainer2Id;

}
