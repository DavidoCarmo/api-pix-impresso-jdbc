package br.senac.pr.api_pix_impresso.caixa;

import java.util.List;

import br.senac.pr.api_pix_impresso.caixa.dtos.CreateCaixaDto;
import br.senac.pr.api_pix_impresso.shared.models.Caixa;

public interface CaixaService {
  public Caixa save(CreateCaixaDto dto);

  public List<Caixa> findAll();

  public Caixa findById(Long id);

  public void update(Caixa object);

  public void deleteById(Long id);
}
