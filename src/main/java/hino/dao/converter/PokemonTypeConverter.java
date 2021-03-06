package hino.dao.converter;

import hino.common.PokemonType;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PokemonTypeConverter implements AttributeConverter<PokemonType, String> {

  /**
   * Converts the value stored in the entity attribute into the data representation to be stored in the database.
   *
   * @param attribute the entity attribute value to be converted
   * @return the converted data to be stored in the database column
   */
  @Override
  public String convertToDatabaseColumn(PokemonType attribute) {
    if (attribute == null) {
      return null;
    }
    return attribute.getType();
  }

  /**
   * Converts the data stored in the database column into the value to be stored in the entity attribute. Note that it is the responsibility of the
   * converter writer to specify the correct <code>dbData</code> dbData for the corresponding column for use by the JDBC driver: i.e., persistence
   * providers are not expected to do such dbData conversion.
   *
   * @param dbData the data from the database column to be converted
   * @return the converted value to be stored in the entity attribute
   */
  @Override
  public PokemonType convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }

    return Stream.of(PokemonType.values())
        .filter(c -> c.getType().equals(dbData))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
