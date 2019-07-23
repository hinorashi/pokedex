package hino.domain;

import hino.common.PokemonType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Your beloved pokemon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

  @ApiModelProperty("Kanto Pokedex number")
  private int id;

  private String name;

  private List<PokemonType> types;

  /**
   * base stats in total
   */
  @ApiModelProperty("Base stats in total")
  private int stat;

  private List<String> moves;
}
