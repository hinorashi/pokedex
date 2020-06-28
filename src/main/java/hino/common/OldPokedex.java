package hino.common;

import static hino.common.PokemonType.BUG;
import static hino.common.PokemonType.DRAGON;
import static hino.common.PokemonType.ELECTRIC;
import static hino.common.PokemonType.FIGHTING;
import static hino.common.PokemonType.FIRE;
import static hino.common.PokemonType.FLYING;
import static hino.common.PokemonType.GHOST;
import static hino.common.PokemonType.GRASS;
import static hino.common.PokemonType.ICE;
import static hino.common.PokemonType.POISON;
import static hino.common.PokemonType.PSYCHIC;
import static hino.common.PokemonType.WATER;

import hino.domain.Pokemon;
import hino.domain.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Pokemons from this uncompleted Pokedex was collected by Red
 */
@Deprecated
public interface OldPokedex {

  List<Type> TYPE_LIST = Arrays.asList(
      Type.builder().name(WATER).build(),
      Type.builder().name(FIGHTING).build(),
      Type.builder().name(FIRE).build(),
      Type.builder().name(FLYING).build(),
      Type.builder().name(DRAGON).build(),
      Type.builder().name(ELECTRIC).build(),
      Type.builder().name(GRASS).build(),
      Type.builder().name(ICE).build(),
      Type.builder().name(POISON).build(),
      Type.builder().name(GHOST).build(),
      Type.builder().name(BUG).build(),
      Type.builder().name(PSYCHIC).build()
  );

  /**
   * data from <a href="https://www.pokemon.com/us/pokedex/">https://www.pokemon.com/us/pokedex/</a>
   */
  List<Pokemon> POKEMON_LIST = Arrays.asList(
      Pokemon.builder().id(62).name("Poliwrath").types(Set.of(
          Type.builder().name(WATER).build(),
          Type.builder().name(FIGHTING).build())
      ).build(),
      Pokemon.builder().id(6).name("Charizard").types(Set.of(
          Type.builder().name(FIRE).build(),
          Type.builder().name(FLYING).build())
      ).build(),
      Pokemon.builder().id(149).name("Dragonite").types(Set.of(
          Type.builder().name(DRAGON).build(),
          Type.builder().name(FLYING).build())
      ).build(),
      Pokemon.builder().id(135).name("Jolteon").types(Set.of(
          Type.builder().name(ELECTRIC).build())
      ).build(),
      Pokemon.builder().id(154).name("Meganium").types(Set.of(
          Type.builder().name(GRASS).build())
      ).build(),
      Pokemon.builder().id(131).name("Lapras").types(Set.of(
          Type.builder().name(WATER).build(),
          Type.builder().name(ICE).build())
      ).build(),
      Pokemon.builder().id(94).name("Gengar").types(Set.of(
          Type.builder().name(POISON).build(),
          Type.builder().name(GHOST).build())
      ).build());
}
