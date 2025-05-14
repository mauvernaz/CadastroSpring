package com.uff.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro/confirmacao")
public class ConfirmacaoController {
    @GetMapping
    public ModelAndView abrirConfirmacao(){
        ModelAndView modelAndView = new ModelAndView("confirmacao");
        return modelAndView;
    }
}
