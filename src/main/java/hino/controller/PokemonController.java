package hino.controller;

import java.util.Collections;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hino.common.PokemonType;
import hino.domain.Pokemon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "pokemon", description = "Your Pokedex")
@RestController
@RequestMapping(path = "pokemons")
public class PokemonController {

  /**
   * @return all pokemon in the pokedex
   */
  @ApiOperation(value = "Let's take a look at your pokedex!", notes = "Reveal all your pokemons...", response = Pokemon.class)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Pokemon> list() {
    var poliwag = Pokemon.builder().id(60).name("poliwag").types(Collections.singletonList(PokemonType.WATER)).build();
    return ResponseEntity.ok(poliwag);
  }

}
