package br.senac.pr.api_pix_impresso.conta.dtos;

public class DetailContaDto {
  private final Long id;
  private final Long agencia;
  private final Long numeroConta;
  private final Long digitoVerificador;
  private final String nome;
  private final String cpf;
  private final Long tipoConta;

  public DetailContaDto(Long id, Long agencia,
      Long numeroConta, Long digitoVerificador,
      String nome, String cpf,
      Long tipoConta) {
    this.id = id;
    this.agencia = agencia;
    this.numeroConta = numeroConta;
    this.digitoVerificador = digitoVerificador;
    this.nome = nome;
    this.cpf = cpf;
    this.tipoConta = tipoConta;
  }

  public Long getId() {
    return id;
  }

  public Long getAgencia() {
    return agencia;
  }

  public Long getNumeroConta() {
    return numeroConta;
  }

  public Long getDigitoVerificador() {
    return digitoVerificador;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public Long getTipoConta() {
    return tipoConta;
  }

}
