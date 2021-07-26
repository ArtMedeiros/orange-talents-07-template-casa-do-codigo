package br.com.zupacademy.kleysson.casadocodigo.config.validation;

import br.com.zupacademy.kleysson.casadocodigo.model.Autor;
import br.com.zupacademy.kleysson.casadocodigo.repository.AutorRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class AutorEmailUniqueValidator implements ConstraintValidator<AutorEmailUnique, String> {

    private AutorRepository autorRepository;

    public AutorEmailUniqueValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public void initialize(AutorEmailUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<Autor> autor = autorRepository.findByEmail(value);

        return autor.isEmpty();
    }
}
