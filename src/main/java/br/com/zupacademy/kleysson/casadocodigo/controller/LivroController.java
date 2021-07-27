package br.com.zupacademy.kleysson.casadocodigo.controller;

import br.com.zupacademy.kleysson.casadocodigo.dto.LivroRequest;
import br.com.zupacademy.kleysson.casadocodigo.dto.LivroResponse;
import br.com.zupacademy.kleysson.casadocodigo.model.Livro;
import br.com.zupacademy.kleysson.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<LivroRequest> cadastrar(@RequestBody @Valid LivroRequest livro) {
        livroRepository.save(livro.converter(autorRepository, categoriaRepository));

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LivroResponse> listarLivros() {
        Iterable<Livro> listaLivros = livroRepository.findAll();

        return LivroResponse.converterLista(listaLivros);
    }
}
