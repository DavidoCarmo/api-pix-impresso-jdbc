package br.senac.pr.api_pix_impresso.dtos;

public class UpdateSaldoCaixaDto {
  private Double saldo;

  public UpdateSaldoCaixaDto(Double saldo) {
    this.saldo = saldo;
  }

  public UpdateSaldoCaixaDto() {
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

}