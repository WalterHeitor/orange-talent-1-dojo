package br.com.zup.nossositedeviagens.validation;

import br.com.zup.nossositedeviagens.rota.NovaRotaFormRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class RotasIguaisValidador implements Validator {

    @PersistenceContext
    EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaRotaFormRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return ;
        }
        NovaRotaFormRequest request = (NovaRotaFormRequest) target;
        if (request.getIdAeroportoOrigem().equals(request.getIdAeroportoDestino())) {
            errors.rejectValue("idAeroportoOrigem", null,
                    "Aeroporto de origem e destino não podem ser iguais.");
        }
    }
}
