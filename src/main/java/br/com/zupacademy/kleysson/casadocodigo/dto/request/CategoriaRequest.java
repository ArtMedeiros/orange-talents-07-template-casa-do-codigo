package br.com.zupacademy.kleysson.casadocodigo.dto.request;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.UniqueColumn;
import br.com.zupacademy.kleysson.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueColumn(field = "nome", entity = Categoria.class)
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
