package net.niantic.pokemon.application.domain.entities.enums.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.niantic.pokemon.application.domain.entities.enums.Type;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ConvertEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.ConvertEnumMaybeNull;

@Converter(autoApply = true)
public class TypeConvertion implements AttributeConverter<Type, String> {

    public ConvertEnum<Type, String> convertEnum = new ConvertEnumMaybeNull<>();

    public String convertToDatabaseColumn(Type type) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(type);
    }

    public Type convertToEntityAttribute(String dbData) {
        return convertEnum.getEnum(Type.values(), dbData);
    }
}
