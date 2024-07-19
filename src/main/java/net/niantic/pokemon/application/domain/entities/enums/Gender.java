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

    Feminino("F","Feminino"),
    Masculino("M","Masculino"),
    Outros("O","Outros"),
    PrefiroNaoDeclarar("P","PrefiroNaoDeclarar");

    private final String valor;
    private final String descricao;

}
