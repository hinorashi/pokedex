package hino.dao;

import hino.domain.Ability;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonAbilityRepository extends JpaRepository<Ability, Integer> {

  @Override
  List<Ability> findAll();

  @Override
  Optional<Ability> findById(Integer integer);

  @Override
  <S extends Ability> S save(S entity);

  @Override
  <S extends Ability> List<S> saveAll(Iterable<S> entities);

  Optional<Ability> findByName(String name);
}
