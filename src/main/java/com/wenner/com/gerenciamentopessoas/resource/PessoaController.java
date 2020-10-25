package com.wenner.com.gerenciamentopessoas.resource;

import com.wenner.com.gerenciamentopessoas.resource.dto.MessageResponseDTO;
import com.wenner.com.gerenciamentopessoas.resource.dto.PessoaDTO;
import com.wenner.com.gerenciamentopessoas.service.PessoaService;
import com.wenner.com.gerenciamentopessoas.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/v1/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaServiceImpl pessoaServiceIpml) {
        this.pessoaService = pessoaServiceIpml;
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public MessageResponseDTO criaPessoa(@RequestBody @Valid PessoaDTO dto) {
        return this.pessoaService.save(dto);
    }

    @GetMapping
    public List<PessoaDTO> listaTodos() {
       return this.pessoaService.listAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO getPessoa(@PathVariable Long id) {
        return this.pessoaService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        return this.pessoaService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        this.pessoaService.delete(id);
    }
}
