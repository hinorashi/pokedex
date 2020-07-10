package hino.domain;

import hino.common.PokemonAbility;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ability implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false, unique = true)
  private PokemonAbility name;

  private String description;
}
