package br.senac.pr.api_pix_impresso.repositories;

import java.util.List;

import br.senac.pr.api_pix_impresso.models.Caixa;

public interface CaixaRepository {
  int save(Caixa caixa);

  int update(Caixa caixa);

  Caixa findById(Long id);

  int deleteById(Long id);

  List<Caixa> findAll();

  int deleteAll();
}
