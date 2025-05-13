package com.uff.cadastro.controller;

import com.uff.cadastro.model.Cadastro;
import com.uff.cadastro.repository.CadastroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

//@AllArgsConstructor
@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    private final CadastroRepository cadastroRepository;

    public CadastroController(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    @GetMapping
    public String abrirCadastro() {
        return "index";
    }

    @PostMapping("/confirmacao")
    public String receberFormulario(
            @RequestParam String nome,
            @RequestParam int idade,
            @RequestParam String dataInicio
    ) {
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
        cadastro.setDataInicio(LocalDate.parse(dataInicio));

        cadastroRepository.save(cadastro);

        return "redirect:/cadastro/confirmacao";
    }
}