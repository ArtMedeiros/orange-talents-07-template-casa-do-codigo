package br.com.zupacademy.kleysson.casadocodigo.controller;

import br.com.zupacademy.kleysson.casadocodigo.dto.request.EstadoRequest;
import br.com.zupacademy.kleysson.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest estado) {
        estadoRepository.save(estado.converter(paisRepository));

        return ResponseEntity.ok().build();
    }
}
