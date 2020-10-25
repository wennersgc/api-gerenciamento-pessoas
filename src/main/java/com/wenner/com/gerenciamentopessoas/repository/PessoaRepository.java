package com.wenner.com.gerenciamentopessoas.repository;

import com.wenner.com.gerenciamentopessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
