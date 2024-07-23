package net.niantic.pokemon.application.domain.entities.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.DesserializadorEnum;

@Getter
@AllArgsConstructor
@JsonDeserialize(using = DesserializadorEnum.class)
public enum Region implements ValorEnum<String> {

    Kanto("Kan","Kanto"),
    Johto("Joh","Johto"),
    Hoenn("Hoe","Hoenn"),
    Sinnoh("Sin","Sinnoh"),
    Unova("Uno","Unova"),
    Kalos("Kal","Kalos"),
    Alola("Alo","Alola"),
    Galar("Gal","Galar");

    private final String value;
    private final String description;

    @Override
    public String getValor() {
        return this.description;
    }
}
