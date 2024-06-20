package br.senac.pr.api_pix_impresso.dtos;

public class UpdateContaCadastroDto {
  private String nome;
  private String cpf;
  private Long tipoConta;

  public UpdateContaCadastroDto(String nome, String cpf, Long tipoConta) {
    this.nome = nome;
    this.cpf = cpf;
    this.tipoConta = tipoConta;
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

}