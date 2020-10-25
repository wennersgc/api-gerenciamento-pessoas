package com.wenner.com.gerenciamentopessoas.resource.dto;

import com.wenner.com.gerenciamentopessoas.model.enums.TipoFone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoFone tipoFone;

    @NotEmpty
    @Size (min = 13, max = 14)
    private String numero;
}
