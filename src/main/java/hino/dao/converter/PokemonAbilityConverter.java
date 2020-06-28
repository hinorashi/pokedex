package hino.dao.converter;

import hino.common.PokemonAbility;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PokemonAbilityConverter implements AttributeConverter<PokemonAbility, String> {

  /**
   * Converts the value stored in the entity attribute into the data representation to be stored in the database.
   *
   * @param attribute the entity attribute value to be converted
   * @return the converted data to be stored in the database column
   */
  @Override
  public String convertToDatabaseColumn(PokemonAbility attribute) {
    if (attribute == null) {
      return null;
    }
    return attribute.getAbility();
  }

  /**
   * Converts the data stored in the database column into the value to be stored in the entity attribute. Note that it is the responsibility of the
   * converter writer to specify the correct <code>dbData</code> type for the corresponding column for use by the JDBC driver: i.e., persistence
   * providers are not expected to do such type conversion.
   *
   * @param dbData the data from the database column to be converted
   * @return the converted value to be stored in the entity attribute
   */
  @Override
  public PokemonAbility convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }

    return Stream.of(PokemonAbility.values())
        .filter(c -> c.getAbility().equals(dbData))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
