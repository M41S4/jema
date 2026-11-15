
package br.com.backend.jema.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepository(
            @Qualifier("mysqlJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean existeEmail(String email) {

        String sql = """
                SELECT COUNT(*)
                FROM usuarios
                WHERE email = ?
                """;

        Integer quantidade = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                email
        );

        return quantidade != null && quantidade > 0;
    }

    public void salvar(String nome, String email, String senhaHash) {

        String sql = """
                INSERT INTO usuarios (nome, email, senha)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(sql, nome, email, senhaHash);
    }

    public String buscarSenhaPorEmail(String email) {

        String sql = """
            SELECT senha
            FROM usuarios
            WHERE email = ?
            """;

        return jdbcTemplate.query(
                sql,
                (resultado, linha) -> resultado.getString("senha"),
                email
        ).stream().findFirst().orElse(null);
    }
}
