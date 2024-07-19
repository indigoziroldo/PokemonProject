package net.niantic.pokemon.application.domain.entities.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.DesserializadorEnum;

@Getter
@AllArgsConstructor
@JsonDeserialize(using = DesserializadorEnum.class)
public enum FavoritePokemon implements ValorEnum<String> {

    Charmander("C","Charmander"),
    Squirtle("S","Squirtle"),
    Bulbassaur("B","Bulbassaur");

    private final String valor;
    private final String descricao;


}
