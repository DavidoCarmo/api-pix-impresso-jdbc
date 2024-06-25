package br.senac.pr.api_pix_impresso.shared.models;

import java.util.HashMap;
import java.util.Map;

public class Conta {
  // Criar os atributos para a tabela Conta
  private Long id;
  private Long agencia;
  private Long numeroConta;
  private Long digitoVerificador;
  private String nome;
  private String cpf;
  private Long tipoConta;
  private String numeroCartao;
  private String senha;
  private Double saldo;

  // Criar um método construtor com todos os atributos
  public Conta(Long id, Long agencia, Long numeroConta, Long digitoVerificador, String nome, String cpf, Long tipoConta,
      String numeroCartao, String senha, Double saldo) {
    this.id = id;
    this.agencia = agencia;
    this.numeroConta = numeroConta;
    this.digitoVerificador = digitoVerificador;
    this.nome = nome;
    this.cpf = cpf;
    this.tipoConta = tipoConta;
    this.numeroCartao = numeroCartao;
    this.senha = senha;
    this.saldo = saldo;
  }
  // Criar os getters e setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAgencia() {
    return agencia;
  }

  public void setAgencia(Long agencia) {
    this.agencia = agencia;
  }

  public Long getNumeroConta() {
    return numeroConta;
  }

  public void setNumeroConta(Long numeroConta) {
    this.numeroConta = numeroConta;
  }

  public Long getDigitoVerificador() {
    return digitoVerificador;
  }

  public void setDigitoVerificador(Long digitoVerificador) {
    this.digitoVerificador = digitoVerificador;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Long getTipoConta() {
    return tipoConta;
  }

  public void setTipoConta(Long tipoConta) {
    this.tipoConta = tipoConta;
  }

  public String getNumeroCartao() {
    return numeroCartao;
  }

  public void setNumeroCartao(String numeroCartao) {
    this.numeroCartao = numeroCartao;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("agencia", agencia);
    map.put("numero_conta", numeroConta);
    map.put("digito_verificador", digitoVerificador);
    map.put("nome", nome);
    map.put("cpf", cpf);
    map.put("tipo_conta", tipoConta);
    map.put("numero_cartao", numeroCartao);
    map.put("senha", senha);
    map.put("saldo", saldo);
    return map;
  }
}
