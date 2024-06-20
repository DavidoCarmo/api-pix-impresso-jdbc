package br.senac.pr.api_pix_impresso.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseJdbcRepository<T, ID> {
  int save(T object);

  void update(T object);

  Optional<T> findById(ID id);

  int deleteById(ID id);

  List<T> findAll();

  int deleteAll();
}