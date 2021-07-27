package br.com.zupacademy.kleysson.casadocodigo.repository;

import br.com.zupacademy.kleysson.casadocodigo.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
