package com.uff.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro/confirmacao")
public class ConfirmacaoController {
    @GetMapping
    public String abrirConfirmacao(){
        return "confirmacao";
    }
}
