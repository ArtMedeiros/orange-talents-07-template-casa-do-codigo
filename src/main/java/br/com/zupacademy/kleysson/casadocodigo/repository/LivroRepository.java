package br.com.zupacademy.kleysson.casadocodigo.repository;

import br.com.zupacademy.kleysson.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
