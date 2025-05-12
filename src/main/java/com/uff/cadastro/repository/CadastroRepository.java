package com.uff.cadastro.repository;

import com.uff.cadastro.model.Cadastro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CadastroRepository {
    private final JdbcTemplate jdbcTemplate;

    public CadastroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Cadastro cadastro) {
        String sql = "INSERT INTO cadastros (nome, idade, data_inicio) VALUES (?,?,?)";
        jdbcTemplate.update(
                sql,
                cadastro.getNome(),
                cadastro.getIdade(),
                cadastro.getDataInicio()
        );
    }
}
