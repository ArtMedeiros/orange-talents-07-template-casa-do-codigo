package br.com.zupacademy.kleysson.casadocodigo.dto;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.CategoriaUnique;
import br.com.zupacademy.kleysson.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequestResponse {

    @NotBlank
    @CategoriaUnique
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
