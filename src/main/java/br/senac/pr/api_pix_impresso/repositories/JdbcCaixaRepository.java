package br.senac.pr.api_pix_impresso.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.models.Caixa;

@Repository
public class JdbcCaixaRepository implements CaixaRepository {

  
  private JdbcTemplate jdbcTemplate;

  public JdbcCaixaRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

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
        return jdbcTemplate
            .query("SELECT ID, LOCALIZACAO, SALDO FROM CAIXAS",
                (rs, rowNum) -> {
                    return new Caixa(rs.getLong("ID"),
                        rs.getString("LOCALIZACAO"),
                        rs.getDouble("SALDO"));
        });
      }
  @Override
  public int deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }
    
    }
