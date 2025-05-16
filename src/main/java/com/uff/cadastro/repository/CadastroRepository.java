package com.uff.cadastro.repository;

import com.uff.cadastro.model.Cadastro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CadastroRepository {
    private final JdbcTemplate jdbcTemplate;

    public CadastroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public Cadastro save(Cadastro cadastro) {
        String sql = "INSERT INTO cadastros (nome, idade, data_inicio) VALUES (?,?,?)";
        jdbcTemplate.update(
                sql,
                cadastro.getNome(),
                cadastro.getIdade(),
                cadastro.getDataInicio()
        );
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        cadastro.setId(id);
        return cadastro;
    }

    public Cadastro findById(Long id) {
        String sql = "SELECT * FROM cadastros WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Cadastro cadastro = new Cadastro();
            cadastro.setId(rs.getLong("id"));
            cadastro.setNome(rs.getString("nome"));
            cadastro.setIdade(rs.getInt("idade"));
            cadastro.setDataInicio(rs.getDate("data_inicio").toLocalDate());
            return cadastro;
        }, id);
    }

    public void update(Long id, Cadastro cadastro) {
        String sql = "UPDATE cadastros SET nome = ?, idade = ?, data_inicio = ? WHERE id = ?";
        jdbcTemplate.update(
                sql,
                cadastro.getNome(),
                cadastro.getIdade(),
                cadastro.getDataInicio(),
                id
        );
    }

    public List<Cadastro> findAll() {
        String sql = "SELECT * FROM cadastros";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cadastro cadastro = new Cadastro();
            cadastro.setId(rs.getLong("id"));
            cadastro.setNome(rs.getString("nome"));
            cadastro.setIdade(rs.getInt("idade"));
            cadastro.setDataInicio(LocalDate.parse(rs.getString("data_inicio")));
            return cadastro;
        });
    }

    }
