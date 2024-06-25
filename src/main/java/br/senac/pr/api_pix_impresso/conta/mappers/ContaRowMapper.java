package br.senac.pr.api_pix_impresso.conta.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import br.senac.pr.api_pix_impresso.shared.models.Conta;

public class ContaRowMapper implements RowMapper<Conta> {

  @Override

  public Conta mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
    return new Conta(rs.getLong("id"),
        rs.getLong("agencia"),
        rs.getLong("numero_conta"),
        rs.getLong("digito_verificador"),
        rs.getString("nome"),
        rs.getString("cpf"),
        rs.getLong("tipo_conta"),
        rs.getString("numero_cartao"),
        rs.getString("senha"),
        rs.getDouble("SALDO"));
  }

}
