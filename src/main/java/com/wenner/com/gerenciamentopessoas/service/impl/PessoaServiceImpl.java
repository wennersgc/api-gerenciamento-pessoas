package com.wenner.com.gerenciamentopessoas.service.impl;

import com.wenner.com.gerenciamentopessoas.model.Pessoa;
import com.wenner.com.gerenciamentopessoas.repository.PessoaRepository;
import com.wenner.com.gerenciamentopessoas.resource.dto.MessageResponseDTO;
import com.wenner.com.gerenciamentopessoas.resource.dto.PessoaDTO;
import com.wenner.com.gerenciamentopessoas.service.PessoaService;
import com.wenner.com.gerenciamentopessoas.service.exception.RecursoNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository, ModelMapper modelMapper) {
        this.pessoaRepository = pessoaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageResponseDTO save(PessoaDTO dto) {
        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
        Pessoa savePessoa = this.pessoaRepository.save(pessoa);

        return MessageResponseDTO
                .builder()
                .mensagem("Pessoa criada com sucesso: id " + savePessoa.getId())
                .build();
    }

    @Override
    public List<PessoaDTO> listAll() {
        List<Pessoa> list = this.pessoaRepository.findAll();

        List<PessoaDTO> pessoas = list.stream()
                            .map(pessoa -> modelMapper.map(pessoa, PessoaDTO.class)
                        ).collect(Collectors.toList());

        return pessoas;
    }

    @Override
    public PessoaDTO findById(Long id) {
       Pessoa pessoa = verificaSePessoaExiste(id);
       return  modelMapper.map(pessoa, PessoaDTO.class);
    }

    @Override
    public void delete(Long id) {
        Pessoa pessoa = verificaSePessoaExiste(id);
        this.pessoaRepository.delete(pessoa);
    }

    private Pessoa verificaSePessoaExiste(Long id) {
        return this.pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada."));
    }
}
