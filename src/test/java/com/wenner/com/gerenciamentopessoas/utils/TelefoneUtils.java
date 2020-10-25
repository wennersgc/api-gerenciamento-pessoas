package com.wenner.com.gerenciamentopessoas.utils;

import com.wenner.com.gerenciamentopessoas.model.Telefone;
import com.wenner.com.gerenciamentopessoas.model.enums.TipoFone;
import com.wenner.com.gerenciamentopessoas.resource.dto.TelefoneDTO;

public class TelefoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final TipoFone PHONE_TYPE = TipoFone.MOBILE;
    private static final long PHONE_ID = 1L;

    public static TelefoneDTO criaFakeDTO() {
        return TelefoneDTO.builder()
                .numero(PHONE_NUMBER)
                .tipoFone(PHONE_TYPE)
                .build();
    }

    public static Telefone criaFakeEntitty() {
        return Telefone.builder()
                .numero(PHONE_NUMBER)
                .tipoFone(PHONE_TYPE)
                .id(PHONE_ID)
                .build();
    }
}
