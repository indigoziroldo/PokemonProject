package net.niantic.pokemon.application.domain.entities.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.DesserializadorEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;

@Getter

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonDeserialize(using = DesserializadorEnum.class)
public enum Gym implements ValorEnum<String> {

    Stone("Stone","Brock" ),
    Water("Water", "Misty"),
    Eletric("Eletric", "Lt. Surge"),
    Plant("Plant", "Erika"),
    Poison("Poison", "Koga"),
    Psych("Psych", "Sabrina"),
    Fire("Fire", "Blaine"),
    Earth("Earth", "Giovanni");

    private final String badge;
    private final String leader;

    public String getValor(){
        return this.badge;
    }

}
