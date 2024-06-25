package br.senac.pr.api_pix_impresso.transacao.dtos;

public class CreateTransacaoDto {
  private Long caixaId;
  private Long contaId;
  private String tipoTransacao;
  private Double valor;

  public CreateTransacaoDto(Long caixaId, Long contaId, String tipoTransacao, Double valor) {
    this.caixaId = caixaId;
    this.contaId = contaId;
    this.tipoTransacao = tipoTransacao;
    this.valor = valor;
  }

  public Long getCaixaId() {
    return caixaId;
  }

  public void setCaixaId(Long caixaId) {
    this.caixaId = caixaId;
  }

  public Long getContaId() {
    return contaId;
  }

  public void setContaId(Long contaId) {
    this.contaId = contaId;
  }

  public String getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(String tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}
