package hino.service;

import hino.domain.Pokemon;
import java.util.List;
import java.util.Optional;

public interface PokemonService {

  List<Pokemon> list();

  Optional<Pokemon> findById(Integer id);

  int updateBuddyName(Integer id, String alias);
}
