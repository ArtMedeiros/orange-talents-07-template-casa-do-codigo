package br.com.zupacademy.kleysson.casadocodigo.repository;

import br.com.zupacademy.kleysson.casadocodigo.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}
