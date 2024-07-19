package net.niantic.pokemon.application.domain.entities.enums.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.niantic.pokemon.application.domain.entities.enums.Region;
import net.niantic.pokemon.application.domain.entities.enums.convert.interfaces.ConvertEnum;
import net.niantic.pokemon.application.domain.entities.enums.convert.service.ConvertEnumMaybeNull;

@Converter(autoApply = true)
public class RegionConverter implements AttributeConverter<Region, String> {

    private ConvertEnum<Region, String> convertEnum = new ConvertEnumMaybeNull<>();

    public String convertToDatabaseColumn(Region region) {
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(region);
    }

    public Region convertToEntityAttribute(String dbData) {
        return convertEnum.getEnum(Region.values(), dbData);
    }
}
