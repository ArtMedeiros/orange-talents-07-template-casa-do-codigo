package br.com.zupacademy.kleysson.casadocodigo.controller;

import br.com.zupacademy.kleysson.casadocodigo.dto.AutorResponse;
import br.com.zupacademy.kleysson.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.kleysson.casadocodigo.model.Autor;
import br.com.zupacademy.kleysson.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest autorForm) {
        Autor autor = autorForm.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok().build();
    }
}
