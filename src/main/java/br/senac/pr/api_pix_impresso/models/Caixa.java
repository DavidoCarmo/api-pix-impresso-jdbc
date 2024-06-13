package br.senac.pr.api_pix_impresso.models;

public class Caixa {
  private Long id;
  private String localizacao;
  private double saldo;

  public Caixa(Long id, String localizacao, double saldo) {
    this.id = id;
    this.localizacao = localizacao;
    this.saldo = saldo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
    Long temp;
    temp = Double.doubleToLongBits(saldo);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Caixa other = (Caixa) obj;
    if (id != other.id)
      return false;
    if (localizacao == null) {
      if (other.localizacao != null)
        return false;
    } else if (!localizacao.equals(other.localizacao))
      return false;
    if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
      return false;
    return true;
  }

}