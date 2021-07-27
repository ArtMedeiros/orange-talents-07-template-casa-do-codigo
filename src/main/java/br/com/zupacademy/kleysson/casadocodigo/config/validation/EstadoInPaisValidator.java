package br.com.zupacademy.kleysson.casadocodigo.config.validation;

import br.com.zupacademy.kleysson.casadocodigo.dto.request.ClienteRequest;
import br.com.zupacademy.kleysson.casadocodigo.model.Estado;
import br.com.zupacademy.kleysson.casadocodigo.model.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;

@Component
public class EstadoInPaisValidator implements Validator {

    private EntityManager em;

    public EstadoInPaisValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ClienteRequest request = (ClienteRequest) o;

        if(request.estadoIsPresent()) {
            Pais pais = em.find(Pais.class, request.getPais());
            Estado estado = em.find(Estado.class, request.getEstado());

            if(!estado.pertencePais(pais))
                errors.rejectValue("estado", null,"Este estado não é do país selecionado");
        }
    }
}
