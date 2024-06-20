package br.senac.pr.api_pix_impresso.services;

import java.util.List;

import br.senac.pr.api_pix_impresso.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateContaDto;

public interface ContaService {

  public DetailContaDto save(CreateContaDto dto);

  public List<DetailContaDto> findAll();

  public DetailContaDto findById(Long id);

  public DetailContaDto update(UpdateContaDto conta);

  public void deleteById(Long id);

}