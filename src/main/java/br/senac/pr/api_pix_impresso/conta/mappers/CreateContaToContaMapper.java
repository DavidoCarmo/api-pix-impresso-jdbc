package br.senac.pr.api_pix_impresso.conta.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.conta.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.shared.models.Conta;

@Service
public class CreateContaToContaMapper implements Function<CreateContaDto, Conta> {

  @Override
  public Conta apply(CreateContaDto dto) {
    return new Conta(null, dto.agencia(), dto.numeroConta(),
        dto.digitoVerificador(), dto.nome(),
        dto.cpf(), dto.tipoConta(), null,
        null, 0.0);
  }

}
