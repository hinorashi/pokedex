package hino.dao;

import hino.domain.Pokemon;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>, PokemonRepositoryCustom {

  @Override
  List<Pokemon> findAll();

  @Override
  Optional<Pokemon> findById(Integer id);

  @Override
  <S extends Pokemon> S save(S entity);

  @Override
  <S extends Pokemon> List<S> saveAll(Iterable<S> entities);

  Optional<Pokemon> findByName(String name);

  @Transactional
  @Modifying
  @Query("UPDATE Pokemon p SET p.alias = :alias WHERE p.id = :id")
  int updateBuddyName(Integer id, String alias);
}
