package br.com.zupacademy.kleysson.casadocodigo.dto;

import br.com.zupacademy.kleysson.casadocodigo.model.Livro;

public class DetalhesLivroResponse {

    private String titulo;
    private String resumo;
    private String sumario;
    private double preco;
    private int paginas;
    private String isbn;
    private AutorResponse autor;

    public DetalhesLivroResponse(Livro livro) {
        this.titulo = livro.getNome();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.isbn = livro.getIsbn();
        this.autor = new AutorResponse(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public AutorResponse getAutor() {
        return autor;
    }
}
