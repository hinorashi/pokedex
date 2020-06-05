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
  ICE("ice"),
  GRASS("grass"),
  BUG("bug"),
  ELECTRIC("electric"),
  GHOST("ghost"),
  POISON("poison"),
  FLYING("flying"),
  PSYCHIC("psychic"),
  FIGHTING("fighting"),
  DRAGON("dragon");

  private String type;
}
