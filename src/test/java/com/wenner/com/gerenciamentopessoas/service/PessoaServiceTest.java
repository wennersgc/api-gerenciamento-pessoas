package com.wenner.com.gerenciamentopessoas.service;

import com.wenner.com.gerenciamentopessoas.model.Pessoa;
import com.wenner.com.gerenciamentopessoas.repository.PessoaRepository;
import com.wenner.com.gerenciamentopessoas.resource.dto.MessageResponseDTO;
import com.wenner.com.gerenciamentopessoas.resource.dto.PessoaDTO;
import com.wenner.com.gerenciamentopessoas.service.impl.PessoaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.wenner.com.gerenciamentopessoas.utils.PessoaUtils.criaFakeDTO;
import static com.wenner.com.gerenciamentopessoas.utils.PessoaUtils.criaFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class PessoaServiceTest {

    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        pessoaService = new PessoaServiceImpl(pessoaRepository);
    }

    @Test
    void deveRetornarSucesso_AoCriarUmaPessoa() {
        PessoaDTO pessoaDTO = criaFakeDTO();
        Pessoa pessoaEsperadaParaSalvar = criaFakeEntity();

        Mockito
                .when(pessoaRepository.save(Mockito.any(Pessoa.class)))
                .thenReturn(pessoaEsperadaParaSalvar);

        MessageResponseDTO mensagemEsperada = createMessageResponse(pessoaEsperadaParaSalvar.getId());
        MessageResponseDTO messageResponseDTO = pessoaService.save(pessoaDTO);

        assertEquals(mensagemEsperada, messageResponseDTO);

    }

    private MessageResponseDTO createMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .mensagem("Pessoa criada com sucesso: id "  + id)
                .build();
    }
}
