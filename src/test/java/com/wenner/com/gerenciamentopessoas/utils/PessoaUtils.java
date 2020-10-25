package com.wenner.com.gerenciamentopessoas.utils;

import com.wenner.com.gerenciamentopessoas.model.Pessoa;
import com.wenner.com.gerenciamentopessoas.resource.dto.PessoaDTO;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PessoaDTO criaFakeDTO() {
        return  PessoaDTO.builder()
                .primeiroNome(FIRST_NAME)
                .ultimoNome(LAST_NAME)
                .cpf(CPF_NUMBER)
                .dataNascimento(BIRTH_DATE)
                .telefones(Collections.singletonList(TelefoneUtils.criaFakeDTO()))
                .build();
    }

    public static Pessoa criaFakeEntity() {
        return  Pessoa.builder()
                .primeiroNome(FIRST_NAME)
                .ultimoNome(LAST_NAME)
                .cpf(CPF_NUMBER)
                .dataNascimento(BIRTH_DATE)
                .telefones(Collections.singletonList(TelefoneUtils.criaFakeEntitty()))
                .id(PERSON_ID)
                .build();
    }
}
