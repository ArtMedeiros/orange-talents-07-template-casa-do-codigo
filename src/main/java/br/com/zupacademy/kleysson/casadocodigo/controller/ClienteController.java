package br.com.zupacademy.kleysson.casadocodigo.controller;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.EstadoInPaisValidator;
import br.com.zupacademy.kleysson.casadocodigo.dto.request.ClienteRequest;
import br.com.zupacademy.kleysson.casadocodigo.dto.response.ClienteResponse;
import br.com.zupacademy.kleysson.casadocodigo.model.Cliente;
import br.com.zupacademy.kleysson.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;
    private EstadoInPaisValidator estadoInPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoInPaisValidator);
    }

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository, EstadoInPaisValidator estadoInPaisValidator) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.estadoInPaisValidator = estadoInPaisValidator;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest cliente) {
        Cliente clienteObj = cliente.converter(paisRepository, estadoRepository);
        clienteRepository.save(clienteObj);

        return ResponseEntity.ok(new ClienteResponse(clienteObj));
    }
}
