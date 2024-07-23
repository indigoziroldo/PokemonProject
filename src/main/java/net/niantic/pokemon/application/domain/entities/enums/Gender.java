package net.niantic.pokemon.application.domain.entities.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ValorEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.DesserializadorEnum;

@Getter
@AllArgsConstructor
@JsonDeserialize(using = DesserializadorEnum.class)
public enum Gender implements ValorEnum<String> { // trocar pra ingles

    Feminino("W","Woman"),
    Masculino("M","Man"),
    Outros("O","Other"),
    PrefiroNaoDeclarar("N","Not Declared");

    private final String value;
    private final String description;

    @Override
    public String getValor() {
        return this.description;
    }
}
