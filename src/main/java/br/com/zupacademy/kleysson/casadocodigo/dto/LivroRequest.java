package br.com.zupacademy.kleysson.casadocodigo.dto;

import br.com.zupacademy.kleysson.casadocodigo.config.validation.ObjectExists;
import br.com.zupacademy.kleysson.casadocodigo.config.validation.UniqueColumn;
import br.com.zupacademy.kleysson.casadocodigo.model.Autor;
import br.com.zupacademy.kleysson.casadocodigo.model.Categoria;
import br.com.zupacademy.kleysson.casadocodigo.model.Livro;
import br.com.zupacademy.kleysson.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.kleysson.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {

    @NotBlank
    @UniqueColumn(field = "titulo", entity = Livro.class)
    private String titulo;

    @NotBlank @Length(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private double preco;

    @NotNull @Min(100)
    private int paginas;

    @NotBlank
    @UniqueColumn(field = "isbn", entity = Livro.class)
    private String isbn;

    @Future
    private LocalDate publicacao;

    @NotNull
    @ObjectExists(field = "id", entity = Categoria.class)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private long categoria;

    @NotNull
    @ObjectExists(field = "id", entity = Autor.class)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private long autor;

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

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autorObj = autorRepository.findById(autor);
        Optional<Categoria> categoriaObj = categoriaRepository.findById(categoria);

        return new Livro(titulo, resumo, sumario, preco, paginas, isbn, publicacao, categoriaObj.get(), autorObj.get());
    }
}
