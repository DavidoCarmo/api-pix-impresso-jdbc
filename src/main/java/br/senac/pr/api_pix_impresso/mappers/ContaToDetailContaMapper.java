package br.senac.pr.api_pix_impresso.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;
import br.senac.pr.api_pix_impresso.mappers.ContaToDetailContaMapper;
import br.senac.pr.api_pix_impresso.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.models.Conta;

@Service
public class ContaToDetailContaMapper implements Function<Conta, DetailContaDto> {

  @Override
  public DetailContaDto apply(Conta conta) {
    return new DetailContaDto(conta.getId(), conta.getAgencia(),
        conta.getNumeroConta(), conta.getDigitoVerificador(),
        conta.getNome(), conta.getCpf(), conta.getTipoConta());
  }

}