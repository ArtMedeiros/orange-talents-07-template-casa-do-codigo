package br.com.zupacademy.kleysson.casadocodigo.dto.response;

import br.com.zupacademy.kleysson.casadocodigo.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroResponse {

    private long id;
    private String nome;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
    }

    public static List<LivroResponse> converterLista(Iterable<Livro> livros) {
        List<LivroResponse> listaLivros = new ArrayList<>();
        livros.forEach(l -> listaLivros.add(new LivroResponse(l)));

        return listaLivros;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
