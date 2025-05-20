package com.uff.cadastro.service;

import com.uff.cadastro.model.Cadastro;
import com.uff.cadastro.repository.CadastroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastroServiceTest {

    @Mock
    CadastroRepository cadastroRepository;

    @InjectMocks
    CadastroService cadastroService;

    @Test
    void deveSalvarCadastroQuandoDadosValidos() {
        Cadastro cadastroValido = new Cadastro();
        cadastroValido.setNome("Amanda");
        cadastroValido.setIdade(31);
        cadastroValido.setDataInicio(LocalDate.now());

        //when(cadastroRepository.save(any(Cadastro.class))).thenReturn(cadastroValido);

        Cadastro resultado = cadastroService.save(cadastroValido);

        assertNotNull(resultado, "O cadastro salvo não deveria ser null");
        assertEquals("Amanda", resultado.getNome());

        verify(cadastroRepository, times(1)).save(cadastroValido);
    }

    @Test
    void deveLancarExcecaoQuandoSalvarCadastroInvalido() {
        Cadastro cadastroInvalido = new Cadastro();

        //when(cadastroRepository.save(any())).thenThrow(new IllegalArgumentException("Dados Inválidos."));

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroService.save(cadastroInvalido);
        }, "Deveria lançar exceção para cadastro inválido");
}

    @Test
    void deveLancarExcecaoQuandoIdadeInsuficiente() {
        Cadastro cadastroIdadeInvalida = new Cadastro();
        cadastroIdadeInvalida.setIdade(16);

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroService.save(cadastroIdadeInvalida);
        }, "Deveria lançar exceção para idade insuficiente (menor que 17).");

    }

    @Test
    void deveLancarExcecaoQuandoIdadeDescomedida() {
        Cadastro cadastroIdadeInvalida = new Cadastro();
        cadastroIdadeInvalida.setIdade(101);

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroService.save(cadastroIdadeInvalida);
        }, "Deveria lançar exceção para idade descomedida (maior que 100).");

    }

    @Test
    void deveLancarExcecaoQuandoNomeNulo(){
        Cadastro cadastroNomeNulo = new Cadastro();
        cadastroNomeNulo.setNome("");

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroService.save(cadastroNomeNulo);
        }, "Deveria lançar exceção para nome nulo.");
    }

    @Test
    void deveLancarExcecaoQuandoDataImpossivel(){
        Cadastro cadastroDataImpossivel = new Cadastro();
        cadastroDataImpossivel.setDataInicio(LocalDate.now().plusDays(1));

        assertThrows(IllegalArgumentException.class, () -> {
            cadastroService.save(cadastroDataImpossivel);
        }, "Deveria lançar exceção para data inicial impossível.");
    }



}
