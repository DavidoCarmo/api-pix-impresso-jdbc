package br.senac.pr.api_pix_impresso.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.models.Caixa;

@Repository
public class JdbcCaixaRepository implements CaixaRepository {

  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public JdbcCaixaRepository(JdbcTemplate jdbcTemplate,
      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  @Override
  public int save(Caixa caixa) {
    GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

    // SQL placeholders can use named parameters instead of "?".
    String sql = """
          INSERT INTO CAIXAS (LOCALIZACAO, SALDO)
          VALUES(:localizacao, :saldo)
        """;

    Map<String, Object> params = new HashMap<>();
    params.put("localizacao", caixa.getLocalizacao());
    params.put("saldo", caixa.getSaldo());

    namedParameterJdbcTemplate.update(sql,
        new MapSqlParameterSource(params),
        generatedKeyHolder);

    var returnedKeys = generatedKeyHolder.getKeys();
    if (returnedKeys == null) {
      throw new Error("Erro ao salvar o caixa");
    }
    Integer id = (Integer) returnedKeys.get("ID");

    return id;
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