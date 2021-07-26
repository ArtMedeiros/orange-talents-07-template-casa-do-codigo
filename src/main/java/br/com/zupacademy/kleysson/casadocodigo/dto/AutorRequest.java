package br.com.zupacademy.kleysson.casadocodigo.dto;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.AutorEmailUnique;
import br.com.zupacademy.kleysson.casadocodigo.model.Autor;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AutorRequest {

    @NotBlank
    private String nome;

    @Email
    @AutorEmailUnique
    private String email;

    @NotBlank
    @Length(max= 400)
    private String descricao;

    private LocalDateTime instante = LocalDateTime.now();

    public Autor converter() {
        return new Autor(nome, email, descricao, instante);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
