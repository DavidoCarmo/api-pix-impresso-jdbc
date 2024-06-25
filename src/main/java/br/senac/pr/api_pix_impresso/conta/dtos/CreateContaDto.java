package br.senac.pr.api_pix_impresso.conta.dtos;

public record CreateContaDto(
    Long agencia,
    Long numeroConta,
    Long digitoVerificador,
    String nome,
    String cpf,
    Long tipoConta) {
}
