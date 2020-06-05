package hino.dao;

import hino.domain.Pokemon;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer>, PokemonRepositoryCustom {

  @Override
  List<Pokemon> findAll();

  @Override
  Optional<Pokemon> findById(Integer integer);

  @Override
  <S extends Pokemon> S save(S entity);

  @Override
  <S extends Pokemon> List<S> saveAll(Iterable<S> entities);

  Optional<Pokemon> findByName(String name);
}
