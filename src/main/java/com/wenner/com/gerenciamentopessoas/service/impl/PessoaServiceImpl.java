package com.wenner.com.gerenciamentopessoas.service.impl;

import com.wenner.com.gerenciamentopessoas.model.Pessoa;
import com.wenner.com.gerenciamentopessoas.repository.PessoaRepository;
import com.wenner.com.gerenciamentopessoas.resource.dto.MessageResponseDTO;
import com.wenner.com.gerenciamentopessoas.resource.dto.PessoaDTO;
import com.wenner.com.gerenciamentopessoas.service.PessoaService;
import com.wenner.com.gerenciamentopessoas.service.exception.RecursoNaoEncontradoException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaServiceImpl implements PessoaService {

    private final  PessoaRepository pessoaRepository;
    private final ModelMapper modelMapper;

    @Override
    public MessageResponseDTO save(PessoaDTO dto) {
        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
        Pessoa savePessoa = this.pessoaRepository.save(pessoa);

        return createMessageResponse(savePessoa.getId(), "Pessoa criada com sucesso: id ");
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
    public MessageResponseDTO updateById(Long id, PessoaDTO dto) {
        Pessoa pessoa = verificaSePessoaExiste(id);
        pessoa = modelMapper.map(dto, Pessoa.class);
        Pessoa pessoaUpdate = this.pessoaRepository.save(pessoa);

        return createMessageResponse(pessoaUpdate.getId(), "Pessoa atualizada com sucesso: id ");
    }

    @Override
    public void delete(Long id) {
        Pessoa pessoa = verificaSePessoaExiste(id);
        this.pessoaRepository.delete(pessoa);
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .mensagem(message + id)
                .build();
    }

    private Pessoa verificaSePessoaExiste(Long id) {
        return this.pessoaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada."));
    }
}
