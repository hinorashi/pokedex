package hino.controller;

import hino.domain.Pokemon;
import hino.dto.AliasDto;
import hino.service.PokemonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api(tags = "pokemon", description = "Your Pokemons")
@RestController
@RequestMapping(path = "pokemons", produces = MediaType.APPLICATION_JSON_VALUE)
public class PokemonController {

  @Autowired
  private PokemonService pokemonService;

  /**
   * @return all pokemon in the pokedex
   */
  @GetMapping
  @ApiOperation(value = "Let's take a look at your pokedex!", notes = "Reveal all your pokemons...", response = Pokemon.class)
  public ResponseEntity<?> list() {
    return ResponseEntity.ok(pokemonService.list());
  }

  /**
   * get a pokemon by its id, from National Pokedex
   */
  @GetMapping("/{id}")
  @ApiOperation(value = "Let's take a look at your favorite pokemon!", notes = "Reveal your favorite pokemon...", response = Pokemon.class)
  public ResponseEntity<?> getOne(@PathVariable Integer id) {
    return ResponseEntity.ok(pokemonService.findById(id));
  }

  /**
   * name your buddy
   */
  @PatchMapping("/{id}")
  public ResponseEntity<?> nameYourBuddy(@PathVariable Integer id, @RequestBody AliasDto aliasDto) {
    pokemonService.updateBuddyName(id, aliasDto.getAlias());
    return ResponseEntity.noContent().location(ServletUriComponentsBuilder.fromCurrentRequestUri().build(id)).build();
  }
}
