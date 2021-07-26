package br.com.zupacademy.kleysson.casadocodigo.config.validation;

import br.com.zupacademy.kleysson.casadocodigo.model.Categoria;
import br.com.zupacademy.kleysson.casadocodigo.repository.CategoriaRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CategoriaUniqueValidator implements ConstraintValidator<CategoriaUnique, String> {

    private CategoriaRepository categoriaRepository;

    public CategoriaUniqueValidator(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void initialize(CategoriaUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Categoria> categoria = categoriaRepository.findByNome(value);

        return categoria.isEmpty();
    }
}
