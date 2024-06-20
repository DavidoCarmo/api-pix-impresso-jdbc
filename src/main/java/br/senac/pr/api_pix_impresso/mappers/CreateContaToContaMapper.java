package br.senac.pr.api_pix_impresso.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.models.Conta;

@Service
public class CreateContaToContaMapper implements Function<CreateContaDto, Conta> {

  @Override
  public Conta apply(CreateContaDto dto) {
    return new Conta(null, dto.getAgencia(), dto.getNumeroConta(),
        dto.getDigitoVerificador(), dto.getNome(),
        dto.getCpf(), dto.getTipoConta(), dto.getNumeroCartao(),
        dto.getSenha(), dto.getSaldo());
  }

}