package hino.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "Your beloved pokemon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {

  /**
   * id should be manually specified
   */
  @Id
  @ApiModelProperty("Kanto Pokedex number")
  private Integer id;

  private String name;

  @ManyToMany(fetch = EAGER, cascade = ALL)
  private Set<Type> types;

  /**
   * base stats in total
   */
  @ApiModelProperty("Base stats in total")
  private int stat;

  @ManyToMany(fetch = EAGER, cascade = ALL)
  private Set<Move> moves;
}
