package com.wenner.com.gerenciamentopessoas.resource.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String mensagem;
}
