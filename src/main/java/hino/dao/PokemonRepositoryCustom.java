package hino.dao;

import static hino.common.PokemonType.DRAGON;
import static hino.common.PokemonType.ELECTRIC;
import static hino.common.PokemonType.FIGHTING;
import static hino.common.PokemonType.FIRE;
import static hino.common.PokemonType.FLYING;
import static hino.common.PokemonType.GHOST;
import static hino.common.PokemonType.GRASS;
import static hino.common.PokemonType.ICE;
import static hino.common.PokemonType.POISON;
import static hino.common.PokemonType.WATER;

import hino.domain.Pokemon;
import hino.domain.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public interface PokemonRepositoryCustom {

  // FIXME move somewhere else :)
  /**
   * data from <a href="https://www.pokemon.com/us/pokedex/">https://www.pokemon.com/us/pokedex/</a>
   */
  List<Pokemon> pokemonList = Arrays.asList(
      Pokemon.builder().id(62).name("Poliwrath").types(Set.of(
          Type.builder().type(WATER).build(),
          Type.builder().type(FIGHTING).build())
      ).build(),
      Pokemon.builder().id(6).name("Charizard").types(Set.of(
          Type.builder().type(FIRE).build(),
          Type.builder().type(FLYING).build())
      ).build(),
      Pokemon.builder().id(149).name("Dragonite").types(Set.of(
          Type.builder().type(DRAGON).build(),
          Type.builder().type(FLYING).build())
      ).build(),
      Pokemon.builder().id(135).name("Jolteon").types(Set.of(
          Type.builder().type(ELECTRIC).build())
      ).build(),
      Pokemon.builder().id(154).name("Meganium").types(Set.of(
          Type.builder().type(GRASS).build())
      ).build(),
      Pokemon.builder().id(131).name("Lapras").types(Set.of(
          Type.builder().type(WATER).build(),
          Type.builder().type(ICE).build())
      ).build(),
      Pokemon.builder().id(94).name("Gengar").types(Set.of(
          Type.builder().type(POISON).build(),
          Type.builder().type(GHOST).build())
      ).build());
}
