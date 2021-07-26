package br.com.zupacademy.kleysson.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AutorEmailUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutorEmailUnique {
    String message() default "Email já cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
