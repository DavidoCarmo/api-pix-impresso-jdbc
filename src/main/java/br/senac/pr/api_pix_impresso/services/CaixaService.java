package br.senac.pr.api_pix_impresso.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.models.Caixa;
import br.senac.pr.api_pix_impresso.repositories.JdbcCaixaRepository;

@Service
public class CaixaService {
  private JdbcCaixaRepository caixaRepository;

  public CaixaService(JdbcCaixaRepository caixaRepository) {
    this.caixaRepository = caixaRepository;
  }

  public int save(Caixa caixa) {
    // regras de negócio
    if (caixa == null) {
      throw new Error("Dados do caixa inválidos");
    }

    if (caixa.getSaldo() <= 0) {
      throw new Error("Saldo não pode ser menor ou igual a zero");
    }
    return caixaRepository.save(caixa);
  }

  public List<Caixa> findAll() {
    return caixaRepository.findAll();
  }

  public Caixa updateSaldoCaixa(Long id, Double saldo) {
    // Buscar um caixa com o id informado


    
    Caixa caixa = caixaRepository.findById(id);
    // valida se o caixa existe
    if (caixa == null) {
      throw new Error("Caixa não encontrado");
    }


    // atualiza o saldo do caixa descontando o valor do saque
    caixa.setSaldo(saldo);
    caixaRepository.update(caixa);
    return caixa;
  }

  public int update(Long id, Caixa caixa) {
    if (caixa == null) {
      throw new Error("Dados do caixa inválidos");
    }

    if (caixa.getId() <= 0 || caixa.getId() == null) {
      throw new Error("ID do caixa inválido");
    }
    // TODO - Finalizar o método update no repository
    return caixaRepository.update(caixa);
  }

}