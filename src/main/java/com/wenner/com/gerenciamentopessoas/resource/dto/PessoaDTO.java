package com.wenner.com.gerenciamentopessoas.resource.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.wenner.com.gerenciamentopessoas.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;

    @NotEmpty
    @Size (min = 2, max = 100)
    private String primeiroNome;

    @NotEmpty
    @Size (min = 2, max = 100)
    private String ultimoNome;

    @NotEmpty
    @CPF
    private String cpf;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;
}
