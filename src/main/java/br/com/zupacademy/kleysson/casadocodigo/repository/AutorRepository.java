package br.com.zupacademy.kleysson.casadocodigo.repository;

import br.com.zupacademy.kleysson.casadocodigo.model.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);
}
