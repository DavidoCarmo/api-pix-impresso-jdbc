package br.senac.pr.api_pix_impresso.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.models.Caixa;

@Repository
public class JdbcCaixaRepository implements BaseJdbcRepository<Caixa, Long> {

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

    // Executar a instrução SQL para criar um novo registro
    namedParameterJdbcTemplate.update(sql,
        new MapSqlParameterSource(params),
        generatedKeyHolder);

    // {ID: 1, localizacao: "Centro", saldo: 0.0}
    var returnedKeys = generatedKeyHolder.getKeys();
    if (returnedKeys == null) {
      throw new Error("Erro ao salvar o caixa");
    }
    // Obtem do registro inserido, o ID gerado pelo banco
    Integer id = (Integer) returnedKeys.get("ID");

    return id;
  }

  @Override
  public void update(Caixa caixa) {
    // SQL placeholders can use named parameters instead of "?".
    String sql = """
          UPDATE CAIXAS SET LOCALIZACAO = :localizacao, SALDO = :saldo
          WHERE ID = :id
        """;

    Map<String, Object> params = new HashMap<>();
    params.put("localizacao", caixa.getLocalizacao());
    params.put("saldo", caixa.getSaldo());
    params.put("id", caixa.getId());

    // Executar a instrução SQL para criar um novo registro
    namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params));
  }

  @Override
  public Optional<Caixa> findById(Long id) {
    String sql = "SELECT ID, LOCALIZACAO, SALDO FROM CAIXAS WHERE ID = ?";

    Object[] args = new Object[] { id };
    int[] argTypes = { java.sql.Types.INTEGER };
    Caixa caixa = null;
    try {
      caixa = jdbcTemplate.queryForObject(sql, args, argTypes, (rs, rowNum) -> {
        return new Caixa(rs.getLong("ID"),
            rs.getString("LOCALIZACAO"),
            rs.getDouble("SALDO"));
      });
      return Optional.of(caixa);
    } catch (EmptyResultDataAccessException e) {
      return Optional.ofNullable(caixa);
    }
  }

  @Override
  public int deleteById(Long id) {
    String sql = """
          DELETE FROM CAIXAS WHERE ID = :id
        """;

    Map<String, Object> params = new HashMap<>();
    params.put("id", id);

    // Executar a instrução SQL para criar um novo registro
    namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params));

    return 1;
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