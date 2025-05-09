package com.uff.cadastro.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@AllArgsConstructor
@Controller
@RequestMapping("/cadastro")
public class CadastroController {
//    private final NomeService nomeService;
//
//    public CadastroController(NomeService nomeService) {
//        this.nomeService = nomeService;
//    }

    @GetMapping
    public String abrirCadastro() {
    return "index";
    }

    @PostMapping("/enviar")
    public String receberFormulario(
        @RequestParam String nome,
        @RequestParam int idade,
        @RequestParam String dataInicio
    ){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Data Inicio: " + dataInicio);

        return "redirect:/confirmacao";
    }

//    public static class CadastroDTO{
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        private String nome;
//
//    }
//
//    public String nome(){
//        var nome = nomeService.nome();
//        return nome;
//    }


}
