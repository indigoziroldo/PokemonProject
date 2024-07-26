package net.niantic.pokemon.application.domain.rest.forms;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import net.niantic.pokemon.application.domain.rest.dto.PlaceDTO;

import java.util.List;

@Getter
public class BattleForm {

    @Size(min = 1, max = 50)
    private String startTime;
    private String endTime;
    private Long placeId;
    private Long trainer1Id;
    private Long trainer2Id;

}
