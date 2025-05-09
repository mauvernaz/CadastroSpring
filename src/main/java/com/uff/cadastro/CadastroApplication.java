package com.uff.cadastro;

import com.uff.cadastro.controller.CadastroController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Slf4j
public class CadastroApplication {

    public static void main(String[] args) {
        SpringApplication.run(CadastroApplication.class, args);
        //var controlador = map.getBean(CadastroController.class);
        //log.info(controlador.nome());
    }

}
