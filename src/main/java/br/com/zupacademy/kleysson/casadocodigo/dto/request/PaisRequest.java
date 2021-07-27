package br.com.zupacademy.kleysson.casadocodigo.dto.request;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.UniqueColumn;
import br.com.zupacademy.kleysson.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueColumn(field = "nome", entity = Pais.class)
    private String nome;

    public Pais converter() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }
}
