package com.uff.cadastro.controller;

import com.uff.cadastro.model.Cadastro;
import com.uff.cadastro.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

//@AllArgsConstructor
@Controller
@RequestMapping("/pessoa")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    public ModelAndView listarPessoas() {
        ModelAndView modelAndView = new ModelAndView("pessoa/list");
        List<Cadastro> pessoas = cadastroService.findAll();
        modelAndView.addObject("pessoas", pessoas);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView criarPessoa() {
        ModelAndView modelAndView = new ModelAndView("pessoa/new");
        modelAndView.addObject("cadastro", new Cadastro());
        return modelAndView;
    }

    @PostMapping()
    public ModelAndView salvarPessoa(
            @RequestParam String nome,
            @RequestParam int idade,
            @RequestParam String dataInicio
    ) {
        Cadastro cadastro = new Cadastro();
        cadastro.setNome(nome);
        cadastro.setIdade(idade);
        cadastro.setDataInicio(LocalDate.parse(dataInicio));

        cadastroService.save(cadastro);

        ModelAndView modelAndView = new ModelAndView("redirect:/pessoa");
        modelAndView.addObject("cadastro", cadastro);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView visualizarPessoa(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pessoa/show");
        modelAndView.addObject("pessoa", cadastroService.findById(id));
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView editarPessoa(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("pessoa/edit");
        modelAndView.addObject("pessoa", cadastroService.findById(id));
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView atualizarPessoa(@PathVariable Long id, @ModelAttribute Cadastro cadastro) {
        cadastroService.update(id, cadastro);
        ModelAndView modelAndView = new ModelAndView("redirect:/pessoa");
        modelAndView.addObject("cadastro", cadastro);
        return modelAndView;
    }

}