package br.com.zupacademy.kleysson.casadocodigo.controller;

import br.com.zupacademy.kleysson.casadocodigo.dto.CategoriaRequestResponse;
import br.com.zupacademy.kleysson.casadocodigo.model.Categoria;
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
    public ResponseEntity<CategoriaRequestResponse> cadastrar(@RequestBody @Valid CategoriaRequestResponse categoria){
        categoriaRepository.save(categoria.converter());

        return ResponseEntity.ok().build();
    }
}
