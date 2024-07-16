package net.niantic.pokemon.application.domain.entities.enums.convert;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.niantic.pokemon.application.domain.entities.enums.Gym;

@Converter(autoApply = true)
public class GymConvertion implements AttributeConverter<Gym, String> {

    private ConvertEnum<Gym, String> convertEnum = new ConvertEnumMaybeNull<>();

    public String convertToDatabaseColumn(Gym gym){
        return convertEnum.getRepresentacaoValorEnumParaBancoDeDados(gym);
    }

    public Gym convertToEntityAttribute(String dbData){
        return convertEnum.getEnum(Gym.values(), dbData);
    }

}
