package com.wenner.com.gerenciamentopessoas.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoFone {
    HOME("Home"),
    MOBILE("Mobile"),
    COMERCIAL("Comercial");

    private String descricao;
}
