package br.senac.pr.api_pix_impresso.dtos;


// DTO - Data Transfer Object
// Objeto que serve para transferir dados entre
// classes ou etapas de execução
public class UpdateCaixaDto {
  private String localizacao;
  private Double saldo;

  public UpdateCaixaDto(String localizacao, Double saldo) {
    this.localizacao = localizacao;
    this.saldo = saldo;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

}