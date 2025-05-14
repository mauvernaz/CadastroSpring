package com.uff.cadastro.controller;

import com.uff.cadastro.model.Cadastro;
import com.uff.cadastro.repository.CadastroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView abrirCadastro() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cadastro", new Cadastro());
        return modelAndView;
    }

    @PostMapping("/confirmacao")
    public ModelAndView receberFormulario(
            @RequestParam String nome,
            @RequestParam int idade,
            @RequestParam String dataInicio
    ) {
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
        cadastro.setDataInicio(LocalDate.parse(dataInicio));

        cadastroRepository.save(cadastro);

        ModelAndView modelAndView = new ModelAndView("redirect:/cadastro");
        modelAndView.addObject("cadastro", cadastro);
        return modelAndView;
    }
}