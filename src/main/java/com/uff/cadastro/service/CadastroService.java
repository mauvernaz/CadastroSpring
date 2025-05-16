package com.uff.cadastro.service;

import com.uff.cadastro.model.Cadastro;
import com.uff.cadastro.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroService {

    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Cadastro save(Cadastro cadastro) {
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
