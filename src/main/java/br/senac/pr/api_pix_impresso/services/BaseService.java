package br.senac.pr.api_pix_impresso.services;

import java.util.List;

public interface BaseService<T, ID> {

  public int save(T object);

  public List<T> findAll();

  public T findById(ID id);

  public void update(T object);

  public void deleteById(ID id);

}