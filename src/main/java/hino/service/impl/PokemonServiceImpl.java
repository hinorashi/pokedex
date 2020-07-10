package hino.service.impl;

import hino.dao.PokemonRepository;
import hino.domain.Pokemon;
import hino.service.PokemonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
class PokemonServiceImpl implements PokemonService {

  @Autowired
  private PokemonRepository pokemonRepository;

  @Override
  @Cacheable("pokedex")
  public List<Pokemon> list() {
    return pokemonRepository.findAll();
  }

  @Override
  @Cacheable(value = "pokemon", key = "#id")
  public Optional<Pokemon> findById(Integer id) {
    return pokemonRepository.findById(id);
  }

  @Override
  @CachePut(value = "pokemon", key = "#id")
  @Caching(evict = {
      @CacheEvict(value = "pokedex", allEntries = true),
      @CacheEvict(value = "pokemon", key = "#id")
  })
  public int updateBuddyName(Integer id, String alias) {
    return pokemonRepository.updateBuddyName(id, alias);
  }
}
