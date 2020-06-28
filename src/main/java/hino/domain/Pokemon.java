package hino.domain;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

  @Column(nullable = false, unique = true)
  private String name;

  @JoinTable(name = "pokemon_type", inverseJoinColumns = @JoinColumn(name = "type_id"))
  @Builder.Default
  @ManyToMany(fetch = EAGER, cascade = {PERSIST, MERGE})
  private Set<Type> types = new HashSet<>();

  /**
   * base stats in total
   */
  @ApiModelProperty("Base stats in total")
  private int stat;

  @JoinTable(name = "pokemon_ability", inverseJoinColumns = @JoinColumn(name = "ability_id"))
  @Builder.Default
  @ManyToMany(fetch = EAGER, cascade = {PERSIST, MERGE})
  private Set<Ability> abilities = new HashSet<>();

  public void addType(Type type) {
    types.add(type);
  }

  public void addAbility(Ability ability) {
    abilities.add(ability);
  }
}
