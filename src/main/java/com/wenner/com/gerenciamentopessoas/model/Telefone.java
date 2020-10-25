package com.wenner.com.gerenciamentopessoas.model;

import com.wenner.com.gerenciamentopessoas.model.enums.TipoFone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private TipoFone tipoFone;

    @Column (nullable = false)
    private String numero;
}
