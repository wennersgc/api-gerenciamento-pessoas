package com.wenner.com.gerenciamentopessoas.service;

import com.wenner.com.gerenciamentopessoas.resource.dto.MessageResponseDTO;
import com.wenner.com.gerenciamentopessoas.resource.dto.PessoaDTO;

import java.util.List;

public interface PessoaService {
    MessageResponseDTO save(PessoaDTO dto);

    List<PessoaDTO> listAll();

    PessoaDTO findById(Long id);

    void delete(Long id);

    MessageResponseDTO updateById(Long id, PessoaDTO dto);
}
