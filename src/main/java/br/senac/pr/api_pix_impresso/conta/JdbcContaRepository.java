package br.senac.pr.api_pix_impresso.conta;
// TODO - Implementar a interface BaseJdbcRepository

import java.util.Collections;
import java.util.HashMap;

// Implementar todos os métodos para serem usados pelo service

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.conta.mappers.ContaRowMapper;
import br.senac.pr.api_pix_impresso.shared.models.Conta;
import br.senac.pr.api_pix_impresso.shared.repositories.BaseJdbcRepository;

@Repository
public class JdbcContaRepository implements BaseJdbcRepository<Conta, Long> {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private final JdbcTemplate jdbcTemplate;
  private final SimpleJdbcInsert simpleJdbcInsert;
  private final RowMapper<Conta> contaRowMapper;

  public JdbcContaRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
      JdbcTemplate jdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    this.jdbcTemplate = jdbcTemplate;
    this.contaRowMapper = new ContaRowMapper();
    this.simpleJdbcInsert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate());
    simpleJdbcInsert.withTableName("contas");
    simpleJdbcInsert.usingGeneratedKeyColumns("id");
  }

  @Override
  public int save(Conta object) {
    Number id = simpleJdbcInsert.executeAndReturnKey(object.toMap());
    return id.intValue();
  }

  @Override
  public void update(Conta object) {
    String sql = """
        update public.contas
             set agencia = :agencia, numero_conta = :numero_conta,
             digito_verificador = :digito_verificador,
             nome = :nome, cpf = :cpf,
             tipo_conta = :tipo_conta,
             numero_cartao = :numero_cartao,
             senha = :senha, saldo = :saldo
        where id = :id
         """;

    Map<String, Object> params = new HashMap<>();
    params.put("id", object.getId());
    params.put("agencia", object.getAgencia());
    params.put("numero_conta", object.getNumeroConta());
    params.put("digito_verificador", object.getDigitoVerificador());
    params.put("nome", object.getNome());
    params.put("cpf", object.getCpf());
    params.put("tipo_conta", object.getTipoConta());
    params.put("numero_cartao", object.getNumeroCartao());
    params.put("senha", object.getSenha());
    params.put("saldo", object.getSaldo());

    // Executar a instrução SQL para criar um novo registro
    namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params));
  }

  @Override
  public Optional<Conta> findById(Long id) {
    String sql = """
         SELECT id, agencia, numero_conta, digito_verificador,
                nome, cpf, tipo_conta,
                numero_cartao, senha, saldo FROM contas WHERE ID = :id
        """;

    Map<String, Object> parameters = Collections.singletonMap("id", id);
    return namedParameterJdbcTemplate
        .queryForStream(sql, parameters, contaRowMapper)
        .findFirst();
  }

  @Override
  public int deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }

  @Override
  public List<Conta> findAll() {
    String selectQuery = """
          SELECT
            id, agencia, numero_conta,
            digito_verificador, nome, cpf, tipo_conta,
            numero_cartao, senha, saldo
          FROM contas
        """;

    return jdbcTemplate
        .query(selectQuery,
            (rs, rowNum) -> {
              return new Conta(rs.getLong("ID"),
                  rs.getLong("AGENCIA"),
                  rs.getLong("NUMERO_CONTA"),
                  rs.getLong("DIGITO_VERIFICADOR"),
                  rs.getString("NOME"),
                  rs.getString("CPF"),
                  rs.getLong("TIPO_CONTA"),
                  rs.getString("NUMERO_CARTAO"),
                  rs.getString("SENHA"),
                  rs.getDouble("SALDO"));
            });
  }

  @Override
  public int deleteAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
  }

}
