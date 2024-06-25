package br.senac.pr.api_pix_impresso.conta.dtos;

public class UpdateContaSaldoDto {

  private Double saldo;

  public UpdateContaSaldoDto(Double saldo) {
    this.saldo = saldo;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

}
