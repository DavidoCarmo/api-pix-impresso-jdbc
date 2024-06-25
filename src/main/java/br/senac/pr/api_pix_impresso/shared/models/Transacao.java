package br.senac.pr.api_pix_impresso.shared.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "transacoes")
public class Transacao {
  @Id
  private Long id;
  @Column("caixa_id")
  private Long caixaId;
  @Column("conta_id")
  private Long contaId;
  @Column("data_hora")
  private LocalDateTime dataHora;
  @Column("tipo_transacao")
  private char tipoTransacao;
  private Double valor;

  public Transacao(Long caixaId, Long contaId, char tipoTransacao, Double valor) {
    this.caixaId = caixaId;
    this.contaId = contaId;
    this.dataHora = LocalDateTime.now();
    this.tipoTransacao = tipoTransacao;
    this.valor = valor;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public char getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(char tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

}
