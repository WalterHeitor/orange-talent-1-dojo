package br.com.zup.nossositedeviagens.validation;

import br.com.zup.nossositedeviagens.rota.NovaRotaFormRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Component
public class RotaUnicaValidator implements Validator {

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
    	Query query = manager.createQuery("select 1 from Rota r where r.aeroportoOrigem.id = :origem and r.aeroportoDestino.id = :destino");
    	NovaRotaFormRequest request = (NovaRotaFormRequest) target;
    	query.setParameter("origem", request.getIdAeroportoOrigem());
    	query.setParameter("destino", request.getIdAeroportoDestino());
    	List<?> lista = query.getResultList();
    	Assert.state(lista.size() <= 1, "Já existe uma rota com essa origem e destino");

    	if(!lista.isEmpty()) {
    	    errors.rejectValue("origem_destino", null,
                    "Não pode ser repetido os destinos ou origem");
        }
    }
}
