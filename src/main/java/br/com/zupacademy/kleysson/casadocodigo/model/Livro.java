package br.com.zupacademy.kleysson.casadocodigo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String titulo;

    @NotBlank @Length(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull @Min(20)
    private double preco;

    @NotNull @Min(100)
    private int paginas;

    @NotBlank
    private String isbn;

    @Future
    private LocalDate publicacao;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Autor autor;

    public Livro() {}

    public Livro(String titulo, String resumo, String sumario, double preco, int paginas, String isbn, LocalDate publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public String getNome() {
        return this.titulo;
    }

    public long getId() {
        return this.id;
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

    public Autor getAutor() {
        return autor;
    }
}
