package com.uff.cadastro.model;

import java.util.Date;

public class Usuario {
    private String nome;
    private int idade;
    private Date dataInicio;

    public Usuario(String nome, int idade, Date dataInicio) {
        this.nome = nome;
        this.idade = idade;
        this.dataInicio = dataInicio;
    }


}
