package com.uff.cadastro.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class Cadastro {
    private Long id;
    @Setter
    @Getter
    private String nome;
    @Setter
    @Getter
    private int idade;
    @Setter
    @Getter
    private LocalDate dataInicio;

    public Cadastro() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
