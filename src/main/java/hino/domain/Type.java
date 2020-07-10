package hino.domain;

import hino.common.PokemonType;
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
public class Type implements Serializable {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(nullable = false, unique = true)
  private PokemonType name;
}
