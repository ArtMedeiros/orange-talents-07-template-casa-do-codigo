package br.com.zupacademy.kleysson.casadocodigo.dto.request;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.ObjectExists;
import br.com.zupacademy.kleysson.casadocodigo.config.validation.UniqueColumn;
import br.com.zupacademy.kleysson.casadocodigo.model.Estado;
import br.com.zupacademy.kleysson.casadocodigo.model.Pais;
import br.com.zupacademy.kleysson.casadocodigo.repository.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoRequest {

    @NotBlank
    @UniqueColumn(field = "nome", entity = Estado.class)
    private String nome;

    @NotNull
    @ObjectExists(field = "id", entity = Pais.class)
    private long pais;

    public Estado converter(PaisRepository paisRepository) {
        Optional<Pais> paisObj = paisRepository.findById(pais);

        return new Estado(nome, paisObj.get());
    }

    public String getNome() {
        return nome;
    }

    public long getPais() {
        return pais;
    }
}
