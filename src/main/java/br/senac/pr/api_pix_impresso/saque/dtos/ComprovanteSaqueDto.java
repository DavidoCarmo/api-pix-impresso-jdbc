package br.senac.pr.api_pix_impresso.saque.dtos;

import java.time.LocalDateTime;

public record ComprovanteSaqueDto(
    String id,
    Long contaId,
    Long caixaId,
    LocalDateTime dataHora,
    Double valor) {

}
