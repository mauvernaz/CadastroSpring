package com.uff.cadastro.service;

import com.uff.cadastro.model.Cadastro;
import com.uff.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Cadastro save(Cadastro cadastro) {
        if (cadastro.getIdade() < 17 || cadastro.getIdade() > 100) {
            throw new IllegalArgumentException("Idade deve estar entre 17 e 100 anos.");
        }
        if (cadastro.getDataInicio().isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Não é possível uma data de início futura.");
        }
        return cadastroRepository.save(cadastro);
    }

    public Cadastro findById(Long id) {
        return cadastroRepository.findById(id);
    }

    public void update(Long id, Cadastro cadastro) {
        cadastroRepository.update(id, cadastro);
    }

    public List<Cadastro> findAll() {
        return cadastroRepository.findAll();
    }
}
