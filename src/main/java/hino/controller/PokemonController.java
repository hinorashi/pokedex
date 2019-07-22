package hino.controller;

import java.util.Collections;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hino.common.PokemonType;
import hino.domain.Pokemon;

@RestController
@RequestMapping("pokemons")
public class PokemonController {

  /**
   * @return all pokemon in the pokedex
   */
  @GetMapping
  public ResponseEntity<Pokemon> list() {
    var poliwag = Pokemon.builder().id(60).name("poliwag").types(Collections.singletonList(PokemonType.WATER)).build();
    return ResponseEntity.ok(poliwag);
  }

}
