package hino.dao.converter;

import static hino.common.PokemonType.FLYING;
import static hino.common.PokemonType.GRASS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PokemonTypeConverterTest {

  @InjectMocks
  private PokemonTypeConverter converter;

  @Test
  void grass() {
    Assertions.assertEquals(GRASS, converter.convertToEntityAttribute("grass"));
  }

  @Test
  void flying() {
    Assertions.assertEquals("flying", converter.convertToDatabaseColumn(FLYING));
  }
}
