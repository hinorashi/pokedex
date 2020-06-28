package hino.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PokemonAbility {

  /**
   * Powers up Fire-type moves when the Pokémon is in trouble.
   */
  BLAZE("blaze"),
  /**
   * Prevents the use of self-destructing moves.
   */
  DAMP("damp"),
  /**
   * Restores HP if hit by a Water-type move.
   */
  WATER_ABSORB("water absorb"),
  /**
   * Protects the Pokémon from flinching.
   */
  INNER_FOCUS("inner focus"),
  /**
   * Restores HP if hit by an Electric-type move.
   */
  VOLT_ABSORB("volt absorb"),
  /**
   * Powers up Grass-type moves when the Pokémon is in trouble.
   */
  OVERGROW("overgrow"),
  /**
   * Protects the Pokémon from critical hits.
   */
  SHELL_ARMOR("shell armor"),
  /**
   * May disable a move used on the Pokémon.
   */
  CURSED_BODY("cursed body");

  private String ability;
}
