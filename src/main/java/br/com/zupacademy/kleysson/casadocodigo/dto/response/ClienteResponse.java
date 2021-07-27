package br.com.zupacademy.kleysson.casadocodigo.dto.response;

import br.com.zupacademy.kleysson.casadocodigo.model.Cliente;

public class ClienteResponse {

    private Long id;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
