package br.senac.pr.api_pix_impresso.conta.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.conta.dtos.DetailContaDto;
import br.senac.pr.api_pix_impresso.shared.models.Conta;

@Service
public class ContaToDetailContaMapper implements Function<Conta, DetailContaDto> {

  @Override
  public DetailContaDto apply(Conta conta) {
    return new DetailContaDto(conta.getId(), conta.getAgencia(),
        conta.getNumeroConta(), conta.getDigitoVerificador(),
        conta.getNome(), conta.getCpf(), conta.getTipoConta());
  }

}
