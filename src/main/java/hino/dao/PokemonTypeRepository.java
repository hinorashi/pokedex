package hino.dao;

import hino.domain.Type;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonTypeRepository extends JpaRepository<Type, Integer> {

  @Override
  List<Type> findAll();

  @Override
  Optional<Type> findById(Integer integer);

  @Override
  <S extends Type> S save(S entity);

  @Override
  <S extends Type> List<S> saveAll(Iterable<S> entities);

  Optional<Type> findByName(String name);
}
