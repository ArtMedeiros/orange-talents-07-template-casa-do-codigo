package br.com.zupacademy.kleysson.casadocodigo.controller;

import br.com.zupacademy.kleysson.casadocodigo.dto.request.CategoriaRequest;
import br.com.zupacademy.kleysson.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaRequest> cadastrar(@RequestBody @Valid CategoriaRequest categoria){
        categoriaRepository.save(categoria.converter());

        return ResponseEntity.ok().build();
    }
}
