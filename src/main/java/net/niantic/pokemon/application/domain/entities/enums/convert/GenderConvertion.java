package net.niantic.pokemon.application.domain.entities.enums.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.niantic.pokemon.application.domain.entities.enums.Gender;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ConvertEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.ConvertEnumMaybeNull;

@Converter(autoApply = true)
public class GenderConvertion implements AttributeConverter<Gender, String> {

    private ConvertEnum<Gender, String> convertEnum = new ConvertEnumMaybeNull<>();

    public String convertToDatabaseColumn(Gender gender) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(gender);
    }

    public Gender convertToEntityAttribute(String dbData) {
        return convertEnum.getEnum(Gender.values(), dbData);
    }
}
