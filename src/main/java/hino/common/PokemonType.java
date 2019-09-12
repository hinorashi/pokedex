package hino.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PokemonType {

  NORMAL("normal"),
  FIRE("fire"),
  WATER("water"),
  GRASS("grass"),
  ELECTRIC("electric"),
  GHOST("ghost"),
  POISON("poison"),
  DRAGON("dragon");

  private String type;
}
