package net.niantic.pokemon.application.domain.entities.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.DesserializadorEnum;


@Getter
@AllArgsConstructor
@JsonDeserialize(using = DesserializadorEnum.class)
public enum Type implements ValorEnum<String> {

    Normal("Nor","Normal"),
    Fire("Fir","Fire"),
    Water("Wat","Water"),
    Grass("Gra","Grass"),
    Flying("Fly","Flying"),
    Poison("Poi","Poison"),
    Eletric("Ele","Eletric"),
    Ground("Gro","Ground"),
    Rock("Roc","Rock"),
    Psychic("Psy","Psychic"),
    Ice("Ice","Ice"),
    Bug("Bug","Bug"),
    Ghost("Gho","Ghost"),
    Steel("Ste","Steel"),
    Dragon("Dra","Dragon"),
    Dark("Dar","Dark"),
    Fairy("Fai","Fairy"),
    Fight("Fig","Fight");

    private final String value;
    private final String description;

    @Override
    public String getValor() {
        return this.description;
    }
}
