package hino.domain;

import java.util.List;
import hino.common.PokemonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

  private int id;

  private String name;

  private List<PokemonType> types;

  /**
   * base stats in total
   */
  private int stat;

  private List<String> moves;
}
