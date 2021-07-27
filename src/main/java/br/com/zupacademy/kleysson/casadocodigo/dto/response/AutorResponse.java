package br.com.zupacademy.kleysson.casadocodigo.dto.response;

import br.com.zupacademy.kleysson.casadocodigo.model.Autor;

import java.time.LocalDateTime;

public class AutorResponse {

    private String nome;
    private String descricao;

    public AutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
