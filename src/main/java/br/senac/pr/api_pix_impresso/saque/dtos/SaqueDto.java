package br.senac.pr.api_pix_impresso.saque.dtos;

public record SaqueDto(
  String numeroCartao,
  String senha,
  Double valor,
  Long caixaId) {
  
}
