package br.senac.pr.api_pix_impresso.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.models.Caixa;

@Repository
public class JdbcCaixaRepository implements CaixaRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(Caixa caixa) {
    return jdbcTemplate.update(
        "INSERT INTO CAIXAS (LOCALIZACAO, SALDO) VALUES(?,?)",
        new Object[] { caixa.getLocalizacao(), caixa.getSaldo() });
  }

  @Override
  public int update(Caixa caixa) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Caixa findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public int deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public List<Caixa> findAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public int deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

}
