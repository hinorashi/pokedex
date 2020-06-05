package hino.controller;

import hino.dao.PokemonRepository;
import hino.domain.Pokemon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "pokemon", description = "Your Pokemons")
@RestController
@RequestMapping(path = "pokemons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonController {

  @Autowired
  private PokemonRepository pokemonRepository;

  /**
   * @return all pokemon in the pokedex
   */
  @ApiOperation(value = "Let's take a look at your pokedex!", notes = "Reveal all your pokemons...", response = Pokemon.class)
  @GetMapping
  public ResponseEntity<?> list() {
    return ResponseEntity.ok(pokemonRepository.findAll());
  }

  /**
   * get a pokemon by its id, from National Pokedex
   */
  @ApiOperation(value = "Let's take a look at your pokedex!", notes = "Reveal all your pokemons...", response = Pokemon.class)
  @GetMapping("/{id}")
  public ResponseEntity<?> getOne(@PathVariable Integer id) {
    return ResponseEntity.ok(pokemonRepository.findById(id));
  }

}
