package br.senac.pr.api_pix_impresso.conta;

import java.util.List;

import br.senac.pr.api_pix_impresso.conta.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.conta.dtos.UpdateContaDto;

public interface ContaService {

  public DetailContaDto save(CreateContaDto dto);

  public List<DetailContaDto> findAll();

  public DetailContaDto findById(Long id);

  public DetailContaDto update(UpdateContaDto conta);

  public void deleteById(Long id);

}
