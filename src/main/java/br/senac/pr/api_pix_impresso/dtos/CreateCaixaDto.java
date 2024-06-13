package br.senac.pr.api_pix_impresso.dtos;

public class CreateCaixaDto {
  private String localizacao;
  private Double saldo;

  public CreateCaixaDto(String localizacao, Double saldo) {
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