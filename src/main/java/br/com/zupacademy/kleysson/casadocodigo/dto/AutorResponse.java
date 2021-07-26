package br.com.zupacademy.kleysson.casadocodigo.dto;

import java.time.LocalDateTime;

public class AutorResponse {

    private long id;
    private String nome;
    private String descricao;
    private LocalDateTime instante;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
